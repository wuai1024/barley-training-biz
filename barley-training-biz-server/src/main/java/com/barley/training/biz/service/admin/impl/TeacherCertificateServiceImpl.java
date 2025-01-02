package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.TeacherCertificate;
import com.barley.training.biz.mapper.TeacherCertificateMapper;
import com.barley.training.biz.service.admin.TeacherCertificateService;
import com.barley.training.biz.service.convert.TeacherCertificateConvertMapper;
import com.barley.training.stub.biz.request.TeacherCertificateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class TeacherCertificateServiceImpl extends ServiceImpl<TeacherCertificateMapper, TeacherCertificate> implements TeacherCertificateService {

    @Override
    public boolean saveBy(TeacherCertificateRequest request) {
        return this.saveOrUpdate(TeacherCertificateConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(TeacherCertificate::getIsDelete, true)
                .eq(TeacherCertificate::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
