package com.barley.training.biz.controller;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.CourseService;
import com.barley.training.stub.biz.facade.CourseFacade;
import com.barley.training.stub.biz.request.CourseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CourseFacade.URL)
@RequiredArgsConstructor
public class CourseController implements CourseFacade {

    private final CourseService courseService;

    @Override
    public ResponseData<Boolean> save(CourseRequest request) {
        return ResponseData.SUCCESS(courseService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(courseService.removeBy(id));
    }
}
