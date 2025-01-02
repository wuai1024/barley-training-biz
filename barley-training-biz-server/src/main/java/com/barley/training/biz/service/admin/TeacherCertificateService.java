package com.barley.training.biz.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.TeacherCertificate;
import com.barley.training.stub.biz.request.TeacherCertificateRequest;

public interface TeacherCertificateService extends IService<TeacherCertificate> {

    boolean saveBy(TeacherCertificateRequest request);

    boolean removeBy(long id);
}
