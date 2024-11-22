package com.barley.training.biz.controller;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.CourseSupervisionService;
import com.barley.training.stub.biz.facade.CourseSupervisionFacade;
import com.barley.training.stub.biz.request.CourseSupervisionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CourseSupervisionFacade.URL)
@RequiredArgsConstructor
public class CourseSupervisionController implements CourseSupervisionFacade {

    private final CourseSupervisionService courseSupervisionService;


    @Override
    public ResponseData<Boolean> save(CourseSupervisionRequest request) {
        return ResponseData.SUCCESS(courseSupervisionService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(courseSupervisionService.removeBy(id));
    }
}
