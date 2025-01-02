package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.ProjectFundsService;
import com.barley.training.stub.biz.facade.admin.ProjectFundsFacade;
import com.barley.training.stub.biz.request.ProjectFundsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProjectFundsFacade.URL)
@RequiredArgsConstructor
public class ProjectFundsController implements ProjectFundsFacade {

    private final ProjectFundsService projectFundsService;


    @Override
    public ResponseData<Boolean> save(ProjectFundsRequest request) {
        return ResponseData.SUCCESS(projectFundsService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(projectFundsService.removeBy(id));
    }
}
