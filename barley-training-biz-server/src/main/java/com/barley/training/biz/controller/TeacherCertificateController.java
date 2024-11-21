package com.barley.training.biz.controller;

import com.barley.training.biz.service.TeacherCertificateService;
import com.barley.training.stub.biz.facade.TeacherCertificateFacade;
import com.barley.training.stub.biz.request.TeacherCertificateRequest;
import com.barley.common.base.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TeacherCertificateFacade.URL)
@RequiredArgsConstructor
public class TeacherCertificateController implements TeacherCertificateFacade {

    private final TeacherCertificateService teacherCertificateService;


    @Override
    public ResponseData<Boolean> save(TeacherCertificateRequest request) {
        return ResponseData.SUCCESS(teacherCertificateService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(teacherCertificateService.removeBy(id));
    }
}
