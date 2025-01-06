package com.barley.training.biz.service.client.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.TeacherCertificate;
import com.barley.training.biz.mapper.TeacherCertificateMapper;
import com.barley.training.biz.service.client.TeacherCertificateClientService;
import com.barley.training.biz.service.convert.TeacherCertificateConvertMapper;
import com.barley.training.stub.biz.bean.client.TeacherCertificateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherCertificateClientServiceImpl extends ServiceImpl<TeacherCertificateMapper, TeacherCertificate> implements TeacherCertificateClientService {
    @Override
    public List<TeacherCertificateDTO> getListById(long id) {
        List<TeacherCertificate> teacherCertificates = this.lambdaQuery().eq(TeacherCertificate::getTeacherId, id).list();
        return TeacherCertificateConvertMapper.INSTANCE.toDTOList(teacherCertificates);
    }
}
