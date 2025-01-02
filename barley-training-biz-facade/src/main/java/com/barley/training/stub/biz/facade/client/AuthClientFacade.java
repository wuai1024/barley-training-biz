package com.barley.training.stub.biz.facade.client;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.bean.client.ClientDTO;
import com.barley.training.stub.biz.request.AuthRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "AuthFacade", description = "授权中心")
public interface AuthClientFacade {
    String URL = "/client/auth";

    @PostMapping("/login")
    @Operation(summary = "登录授权")
    ResponseData<ClientDTO> login(@RequestBody AuthRequest request);

    @PostMapping("/phone")
    @Operation(summary = "登录授权")
    ResponseData<ClientDTO> loginByPhone(@RequestBody AuthRequest request);

    @GetMapping("/get")
    @Operation(summary = "获取当前用户信息")
    ResponseData<?> getSession();
}
