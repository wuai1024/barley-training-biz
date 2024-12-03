package com.barley.training.biz.controller;

import com.barley.common.base.response.ResponseData;
import com.barley.common.datasource.SearchRequest;
import com.barley.common.datasource.Utils;
import com.barley.training.biz.service.ExportTaskService;
import com.barley.training.stub.biz.bean.ExportTaskDTO;
import com.barley.training.stub.biz.facade.ExportFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ExportFacade.URL_PREFIX)
@RequiredArgsConstructor
public class ExportController implements ExportFacade {
    private final ExportTaskService exportTaskService;
    @Override
    public ResponseData<Boolean> export(String code, String exportCode, String name, SearchRequest request) {
        return ResponseData.SUCCESS(exportTaskService.createTask(Utils.parseCode(code),
                exportCode, name, request.getParams()));
    }

    @Override
    public ResponseData<List<ExportTaskDTO>> getExportTaskList(String code) {
        return ResponseData.SUCCESS(exportTaskService.getExportTaskList(Utils.parseCode(code)));
    }
}
