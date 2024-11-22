package com.barley.training.stub.biz.facade;

import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "SystemFacade", description = "系统")
public interface SystemFacade {
    String URL = "/system";

    @GetMapping("/getTreeMenus")
    @Operation(summary = "获取菜单")
    ResponseData<?> getTreeMenus();
}
