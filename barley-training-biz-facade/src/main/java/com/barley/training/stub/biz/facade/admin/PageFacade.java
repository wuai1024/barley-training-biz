package com.barley.training.stub.biz.facade.admin;

import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "PageFacade", description = "页面查询")
public interface PageFacade {

    String URL = "/page";

    @GetMapping("/{code}")
    @Operation(summary = "表格")
    ResponseData<?> get(@PathVariable String code);
}
