package com.barley.training.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.common.datasource.FileConfig;
import com.barley.common.datasource.service.ExportService;
import com.barley.stub.file.FileCenterTempFile;
import com.barley.stub.file.FileCenterUtils;
import com.barley.training.biz.config.ExportScriptFileConfig;
import com.barley.training.biz.constant.UscResponseCode;
import com.barley.training.biz.constant.enums.ExportTaskStatusEnum;
import com.barley.training.biz.entity.ExportTask;
import com.barley.training.biz.entity.ext.MapExt;
import com.barley.training.biz.mapper.ExportTaskMapper;
import com.barley.training.biz.service.ExportTaskService;
import com.barley.training.biz.service.convert.ExportTaskConvertMapper;
import com.barley.training.stub.biz.bean.ExportTaskDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
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
        final String exportCode = task.getExportConfigCode();
        final MapExt params = task.getParams();
        final FileConfig fileConfig = exportScriptFileConfig.get(exportCode);
        if (Objects.isNull(fileConfig)) {
            throw UscResponseCode.ERROR.newException("配置错误");
        }
        final String fileName = task.getId() + "_" + System.currentTimeMillis() + ".xlsx";
        final String templateName = task.getId() + "_" + System.currentTimeMillis() + "_template.xlsx";
        try (FileCenterTempFile tempFile = FileCenterUtils.createTempFile(fileName)) {
//            try (FileCenterTempFile templateFile = FileCenterUtils.createTempFile(templateName)) {
//
//            }
            exportService.export(fileConfig.getScript(), fileConfig.getConfig(), params, null, tempFile.getFile(), (status, ex) -> {
                final String s3Path = fileName;
                if (status) {
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
            });
        }

    }
}
