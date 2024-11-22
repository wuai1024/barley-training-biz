package com.barley.training.biz.controller;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.ProjectClassService;
import com.barley.training.stub.biz.facade.ProjectClassFacade;
import com.barley.training.stub.biz.request.ProjectClassRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProjectClassFacade.URL)
@RequiredArgsConstructor
public class ProjectClassController implements ProjectClassFacade {

    private final ProjectClassService projectClassService;


    @Override
    public ResponseData<Boolean> save(ProjectClassRequest request) {
        return ResponseData.SUCCESS(projectClassService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(projectClassService.removeBy(id));
    }
}
