package com.barley.training.biz.controller.client;

import com.barley.common.auth.UserContext;
import com.barley.common.auth.session.SessionService;
import com.barley.common.base.Preconditions;
import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.client.StudentClientService;
import com.barley.training.stub.biz.bean.client.ClientDTO;
import com.barley.training.stub.biz.facade.client.AuthClientFacade;
import com.barley.training.stub.biz.request.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AuthClientFacade.URL)
@RequiredArgsConstructor
public class AuthClientController implements AuthClientFacade {

    private final StudentClientService studentClientService;

    private final SessionService sessionService;

    @Override
    public ResponseData<ClientDTO> login(AuthRequest request) {
        return ResponseData.SUCCESS(studentClientService.login(request));
    }

    @Override
    public ResponseData<ClientDTO> loginByPhone(AuthRequest request) {
        Preconditions.checkNotEmpty(request.getCode());
        return ResponseData.SUCCESS(studentClientService.loginByPhone(request));
    }

    @Override
    public ResponseData<?> getSession() {
        return ResponseData.SUCCESS(sessionService.getUserSession(UserContext.getUserId()));
    }
}
