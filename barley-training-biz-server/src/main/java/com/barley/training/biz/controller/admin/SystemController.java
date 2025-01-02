package com.barley.training.biz.controller.admin;

import com.barley.common.auth.UserContext;
import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.MenusService;
import com.barley.training.stub.biz.facade.admin.SystemFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SystemFacade.URL)
@RequiredArgsConstructor
public class SystemController implements SystemFacade {
    private final MenusService menusService;

    @Override
    public ResponseData<?> getTreeMenus() {
        return ResponseData.SUCCESS(menusService.getTreeMenus(UserContext.getIsPrimary(), UserContext.getUserLongId()));
    }
}
