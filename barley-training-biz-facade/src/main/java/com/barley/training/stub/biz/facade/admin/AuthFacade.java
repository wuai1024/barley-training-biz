package com.barley.training.stub.biz.facade.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.bean.admin.UserDTO;
import com.barley.training.stub.biz.request.AuthRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "AuthFacade", description = "授权中心")
public interface AuthFacade {
    String URL = "/admin/auth";

    @PostMapping("/login")
    @Operation(summary = "登录授权")
    ResponseData<UserDTO> login(@RequestBody AuthRequest request);

    @GetMapping("/get")
    @Operation(summary = "获取当前授权信息")
    ResponseData<?> getSession();
}
