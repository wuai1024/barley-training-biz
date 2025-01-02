package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.ProjectService;
import com.barley.training.stub.biz.facade.admin.ProjectFacade;
import com.barley.training.stub.biz.request.ProjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProjectFacade.URL)
@RequiredArgsConstructor
public class ProjectController implements ProjectFacade {

    private final ProjectService projectService;


    @Override
    public ResponseData<Boolean> save(ProjectRequest request) {
        return ResponseData.SUCCESS(projectService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(projectService.removeBy(id));
    }
}
