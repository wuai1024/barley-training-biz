package com.barley.training.stub.biz.facade.admin;

import com.barley.common.base.response.PageData;
import com.barley.common.base.response.ResponseData;
import com.barley.common.datasource.SearchRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Tag(name = "QueryFacade", description = "查询服务")
public interface QueryFacade {

    String URL = "/query";

    @PostMapping("/search/{code}")
    @Operation(summary = "搜查")
    ResponseData<PageData<?>> search(@PathVariable String code, @RequestBody SearchRequest request);

    @PostMapping("/list/{code}")
    @Operation(summary = "列表")
    ResponseData<List<?>> list(@PathVariable String code, @RequestBody HashMap<String, Object> request);

    @PostMapping("/get/{code}")
    @Operation(summary = "详情")
    ResponseData<?> get(@PathVariable String code, @RequestBody HashMap<String, Object> request);
}
