package com.barley.training.biz.controller;

import com.barley.common.auth.UserContext;
import com.barley.common.auth.session.SessionService;
import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.SysUserService;
import com.barley.training.stub.biz.bean.UserDTO;
import com.barley.training.stub.biz.facade.AuthFacade;
import com.barley.training.stub.biz.request.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(AuthFacade.URL)
@RequiredArgsConstructor
public class AuthController implements AuthFacade {

    private final SysUserService sysUserService;
    private final SessionService sessionService;

    @Override
    public ResponseData<UserDTO> login(AuthRequest request) {
        return ResponseData.SUCCESS(sysUserService.login(request));
    }

    @Override
    public ResponseData<?> getSession() {
        if (Objects.isNull(UserContext.get())) {
            return ResponseData.SUCCESS();
        }
        return ResponseData.SUCCESS(sessionService.getUserSession(UserContext.getUserId()));
    }
}
