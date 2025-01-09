package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.CourseService;
import com.barley.training.stub.biz.bean.admin.*;
import com.barley.training.stub.biz.facade.admin.CourseFacade;
import com.barley.training.stub.biz.request.CourseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @Override
    public ResponseData<List<CourseListDTO>> listByProject(long id) {
        return ResponseData.SUCCESS(courseService.listByProject(id));
    }

    @Override
    public ResponseData<List<CourseViewDTO>> videoByCourseId(long id) {
        return ResponseData.SUCCESS(courseService.videoByCourseId(id));
    }

    @Override
    public ResponseData<Boolean> liveById(long id) {
        return ResponseData.SUCCESS(courseService.liveById(id));
    }

    @Override
    public ResponseData<LiveDetailDTO> liveDetailById(long id) {
        return ResponseData.SUCCESS(courseService.liveDetailById(id));
    }

    @Override
    public ResponseData<Boolean> deleteLiveById(long id) {
        return ResponseData.SUCCESS(courseService.deleteLiveById(id));
    }
}
