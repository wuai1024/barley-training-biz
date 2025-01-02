package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.common.datasource.Column;
import com.barley.common.datasource.DynamicQueryTypeEnum;
import com.barley.common.datasource.FileConfig;
import com.barley.common.datasource.service.ExportService;
import com.barley.stub.file.FileCenterTempFile;
import com.barley.stub.file.FileCenterUtils;
import com.barley.stub.file.s3.S3Factory;
import com.barley.tools.common.MapPaths;
import com.barley.training.biz.config.DynamicQueryFileConfig;
import com.barley.training.biz.config.ExportScriptFileConfig;
import com.barley.training.biz.constant.Constant;
import com.barley.training.biz.constant.UscResponseCode;
import com.barley.training.biz.constant.enums.ExportTaskStatusEnum;
import com.barley.training.biz.entity.ExportTask;
import com.barley.training.biz.entity.ext.MapExt;
import com.barley.training.biz.mapper.ExportTaskMapper;
import com.barley.training.biz.service.admin.ExportTaskService;
import com.barley.training.biz.service.admin.PageService;
import com.barley.training.biz.service.convert.ExportTaskConvertMapper;
import com.barley.training.stub.biz.bean.admin.ExportTaskDTO;
import io.vavr.CheckedFunction2;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.barley.common.base.constants.Constants.*;

@Log4j2
@Service
@RequiredArgsConstructor
public class ExportTaskServiceImpl extends ServiceImpl<ExportTaskMapper, ExportTask> implements ExportTaskService {
    private final ExportService exportService;
    private final ExportScriptFileConfig exportScriptFileConfig;
    private final PageService pageService;
    private final DynamicQueryFileConfig dynamicQueryFileConfig;
    private final S3Factory s3Factory;


    @Override
    public boolean createTask(String code, String exportCode, String name, Map<String, Object> params) {
        final ExportTask exportTask = new ExportTask();
        exportTask.setPageCode(code);
        exportTask.setExportConfigCode(exportCode);
        exportTask.setName(name);
        exportTask.setParams(new MapExt(params));
        return this.save(exportTask);
    }

    @Override
    public List<ExportTaskDTO> getExportTaskList(String code) {
        return ExportTaskConvertMapper.INSTANCE.toDTOList(
                this.lambdaQuery().eq(ExportTask::getPageCode, code)
                        .last(LIMIT_50)
                        .orderByDesc(ExportTask::getCreateTime)
                        .list());
    }

    @Override
    public List<ExportTask> getTaskList(int minute) {
        return this.lambdaQuery()
                .in(ExportTask::getStatus, ExportTaskStatusEnum.READY.getCode())
                .ge(ExportTask::getCreateTime, LocalDateTime.now().minusMinutes(minute))
                .last(LIMIT_100)
                .list();
    }

    @Override
    @SneakyThrows
    public void export(ExportTask task) {
        final String pageCode = task.getPageCode();
        final String exportCode = task.getExportConfigCode();
        final String fileName = task.getId() + "_" + System.currentTimeMillis() + ".xlsx";
        try (FileCenterTempFile tempFile = FileCenterUtils.createTempFile(fileName)) {
            var callback = (CheckedFunction2<Boolean, Throwable, Object>) (status, ex) -> {
                if (status) {
                    final String s3Path;
                    try (FileInputStream inputStream = new FileInputStream(tempFile.getFile())) {
                        s3Path = s3Factory.getInstance(Constant.S3_FILE)
                                .putObject("/" + Constant.TRAINING + "/report/" + fileName, inputStream);
                    }
                    // 导出成功
                    log.info("[导出任务] 导出成功(任务: {}), 文件路径: {}", task.getId(), s3Path);
                    this.lambdaUpdate().eq(ExportTask::getId, task.getId())
                            .set(ExportTask::getStatus, ExportTaskStatusEnum.COMPLETED.getCode())
                            .set(ExportTask::getUrl, s3Path)
                            .last(LIMIT_1)
                            .update();
                } else {
                    log.error("[导出任务] 失败: {}", ex.getMessage(), ex);
                    this.lambdaUpdate().eq(ExportTask::getId, task.getId())
                            .set(ExportTask::getStatus, ExportTaskStatusEnum.ERROR.getCode())
                            .set(ExportTask::getMessage, ex.getMessage())
                            .last(LIMIT_1)
                            .update();
                    throw ex;
                }
                return true;
            };
            if (Objects.equals(exportCode, "DEFAULT")) {
                exportDefault(pageCode, tempFile, task, callback);
            } else {
                exportByCode(exportCode, tempFile, task, callback);
            }
        }
    }

    private void exportDefault(String code, FileCenterTempFile outputFile, ExportTask task,
                               CheckedFunction2<Boolean, Throwable, Object> callback) {
        final MapExt params = task.getParams();
        final Map<String, Object> config = pageService.get(code);
        final String tableCode = Objects.toString(MapPaths.getValue(config, "page[0].exportConfig.code"),
                Objects.toString(MapPaths.getValue(config, "page[0].searchConfig.code"), code));
        final FileConfig tableConfig = dynamicQueryFileConfig.get(DynamicQueryTypeEnum.TABLE, tableCode);
        //noinspection unchecked
        final List<Map<String, Object>> columns = MapPaths.getValue(config, "page[0].columns[0].columns", List.class);
        exportService.exportDefault(tableConfig.getSourceType(), tableConfig.getScript(),
                columns.stream().filter(it -> {
                            if (Objects.equals(Objects.toString(it.get("hideInTable")), "true")) {
                                return false;
                            }
                            if (StringUtils.isBlank(Objects.toString(it.get("title"), null))) {
                                return false;
                            }
                            return StringUtils.isNotBlank(Objects.toString(it.get("dataIndex"), null));
                        })
                        .map(it -> {
                            final Column column = new Column();
                            column.setTitle(Objects.toString(it.get("title")));
                            column.setDataIndex(Objects.toString(it.get("dataIndex")));
                            return column;
                        }).toList(),
                params, outputFile.getFile(), callback);
    }

    @SneakyThrows
    private void exportByCode(String exportCode, FileCenterTempFile outputFile, ExportTask task,
                              CheckedFunction2<Boolean, Throwable, Object> callback) {
        final MapExt params = task.getParams();
        final FileConfig fileConfig = exportScriptFileConfig.get(exportCode);
        if (Objects.isNull(fileConfig)) {
            throw UscResponseCode.ERROR.newException("配置错误");
        }

        final String templateName = task.getId() + "_" + System.currentTimeMillis() + "_template.xlsx";
        final String template = Objects.toString(fileConfig.getConfig().get("template"));
        try (FileCenterTempFile templateFile = FileCenterUtils.createTempFile(templateName)) {
            try (InputStream inputStream = this.getClass().getResourceAsStream("/xlsx/" + template)) {
                if (Objects.isNull(inputStream)) {
                    throw UscResponseCode.ERROR.newException("模板不存在");
                }
                try (FileOutputStream fos = new FileOutputStream(templateFile.getFile())) {
                    IOUtils.copy(inputStream, fos);
                }
            }
            exportService.export(fileConfig.getScript(), fileConfig.getConfig(), params,
                    templateFile.getFile(), outputFile.getFile(), callback);
        }
    }
}
