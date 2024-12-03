package com.barley.training.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.ExportTask;
import com.barley.training.stub.biz.bean.ExportTaskDTO;

import java.util.List;
import java.util.Map;

public interface ExportTaskService extends IService<ExportTask> {
    boolean createTask(String code, String exportCode, String name, Map<String, Object> params);

    List<ExportTaskDTO> getExportTaskList(String code);

    List<ExportTask> getTaskList(int minute);

    void export(ExportTask exportTask);
}
