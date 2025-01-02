package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.TeacherCertificateService;
import com.barley.training.stub.biz.facade.admin.TeacherCertificateFacade;
import com.barley.training.stub.biz.request.TeacherCertificateRequest;
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
