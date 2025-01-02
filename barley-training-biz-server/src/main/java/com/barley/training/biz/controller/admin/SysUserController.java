package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.SysUserService;
import com.barley.training.stub.biz.facade.admin.SysUserFacade;
import com.barley.training.stub.biz.request.SysUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SysUserFacade.URL)
@RequiredArgsConstructor
public class SysUserController implements SysUserFacade {
    private final SysUserService sysUserService;

    @Override
    public ResponseData<Boolean> save(SysUserRequest request) {
        return ResponseData.SUCCESS(sysUserService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> resetPassword(long id, String password) {
        return ResponseData.SUCCESS(sysUserService.resetPassword(id, password));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(sysUserService.removeBy(id));
    }
}
