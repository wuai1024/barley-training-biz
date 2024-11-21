package com.barley.training.biz.controller;

import com.barley.training.biz.service.TeacherEvaluationService;
import com.barley.training.stub.biz.facade.TeacherEvaluationFacade;
import com.barley.training.stub.biz.request.TeacherEvaluationRequest;
import com.barley.common.base.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TeacherEvaluationFacade.URL)
@RequiredArgsConstructor
public class TeacherEvaluationController implements TeacherEvaluationFacade {

    private final TeacherEvaluationService teacherEvaluationService;


    @Override
    public ResponseData<Boolean> save(TeacherEvaluationRequest request) {
        return ResponseData.SUCCESS(teacherEvaluationService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(teacherEvaluationService.removeBy(id));
    }
}
