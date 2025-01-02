package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.SysRoleService;
import com.barley.training.stub.biz.facade.admin.SysRoleFacade;
import com.barley.training.stub.biz.request.SysRoleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SysRoleFacade.URL)
@RequiredArgsConstructor
public class SysRoleController implements SysRoleFacade {
    private final SysRoleService sysRoleService;

    @Override
    public ResponseData<Boolean> save(SysRoleRequest request) {
        return ResponseData.SUCCESS(sysRoleService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(sysRoleService.removeBy(id));
    }
}
