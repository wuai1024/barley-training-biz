package com.barley.training.biz.controller;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.TeacherService;
import com.barley.training.stub.biz.facade.TeacherFacade;
import com.barley.training.stub.biz.request.TeacherRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TeacherFacade.URL)
@RequiredArgsConstructor
public class TeacherController implements TeacherFacade {

    private final TeacherService teacherService;


    @Override
    public ResponseData<Boolean> save(TeacherRequest request) {
        return ResponseData.SUCCESS(teacherService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(teacherService.removeBy(id));
    }
}
