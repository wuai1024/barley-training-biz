package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.ProjectFundsFlowService;
import com.barley.training.stub.biz.facade.admin.ProjectFundsFlowFacade;
import com.barley.training.stub.biz.request.ProjectFundsFlowRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProjectFundsFlowFacade.URL)
@RequiredArgsConstructor
public class ProjectFundsFlowController implements ProjectFundsFlowFacade {

    private final ProjectFundsFlowService projectFundsFlowService;


    @Override
    public ResponseData<Boolean> save(ProjectFundsFlowRequest request) {
        return ResponseData.SUCCESS(projectFundsFlowService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(projectFundsFlowService.removeBy(id));
    }
}
