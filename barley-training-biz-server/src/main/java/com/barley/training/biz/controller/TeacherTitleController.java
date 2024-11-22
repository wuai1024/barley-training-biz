package com.barley.training.biz.controller;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.TeacherTitleService;
import com.barley.training.stub.biz.facade.TeacherTitleFacade;
import com.barley.training.stub.biz.request.TeacherTitleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TeacherTitleFacade.URL)
@RequiredArgsConstructor
public class TeacherTitleController implements TeacherTitleFacade {

    private final TeacherTitleService teacherTitleService;


    @Override
    public ResponseData<Boolean> save(TeacherTitleRequest request) {
        return ResponseData.SUCCESS(teacherTitleService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(teacherTitleService.removeBy(id));
    }
}
