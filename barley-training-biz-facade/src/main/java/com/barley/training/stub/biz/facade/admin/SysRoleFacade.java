package com.barley.training.stub.biz.facade.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.request.SysRoleRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "SysRoleFacade", description = "系统角色")
public interface SysRoleFacade {
    String URL = "/admin/sysRole";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody SysRoleRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户")
    ResponseData<Boolean> deleteById(@PathVariable long id);
}
