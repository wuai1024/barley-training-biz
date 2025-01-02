package com.barley.training.stub.biz.facade.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.request.SysUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "SysUserFacade", description = "系统用户")
public interface SysUserFacade {
    String URL = "/admin/sysUser";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody SysUserRequest request);

    @PostMapping("/resetPassword")
    @Operation(summary = "重置密码")
    ResponseData<Boolean> resetPassword(@RequestParam long id, @RequestParam String password);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户")
    ResponseData<Boolean> deleteById(@PathVariable long id);
}
