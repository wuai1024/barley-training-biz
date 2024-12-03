package com.barley.training.stub.biz.facade;

import com.barley.common.base.response.ResponseData;
import com.barley.common.datasource.SearchRequest;
import com.barley.training.stub.biz.bean.ExportTaskDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "ExportFacade", description = "导出管理")
public interface ExportFacade {
    String URL_PREFIX = "/export";

    @Operation(summary = "导出数据")
    @PostMapping(value = "/{code}")
    ResponseData<Boolean> export(@PathVariable(value = "code") String code,
                                 @RequestParam String exportCode,
                                 @RequestParam(defaultValue = "", required = false) String name,
                                 @RequestBody SearchRequest request);

    @Operation(summary = "获取导出任务列表")
    @GetMapping(value = "/getExportTaskList/{code}")
    ResponseData<List<ExportTaskDTO>> getExportTaskList(@PathVariable(value = "code") String code);
}
