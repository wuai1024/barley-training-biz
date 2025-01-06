package com.barley.training.biz.service.client.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.Teacher;
import com.barley.training.biz.mapper.TeacherMapper;
import com.barley.training.biz.service.client.TeacherCertificateClientService;
import com.barley.training.biz.service.client.TeacherClientService;
import com.barley.training.biz.service.convert.TeacherConvertMapper;
import com.barley.training.stub.biz.bean.client.TeacherDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TeacherClientServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherClientService {

    private final TeacherCertificateClientService teacherCertificateClientService;

    @Override
    public List<TeacherDTO> getList() {
        List<Teacher> teachers = this.list();
        if (CollectionUtils.isEmpty(teachers)) {
            return Collections.emptyList();
        }
        return TeacherConvertMapper.INSTANCE.toDTOList(teachers);
    }

    @Override
    public TeacherDTO getBy(long id) {
        TeacherDTO teacherDTO = TeacherConvertMapper.INSTANCE.toDTO(this.getById(id));
        if (Objects.nonNull(teacherDTO)) {
            teacherDTO.setCertificateDTOS(teacherCertificateClientService.getListById(id));
        }
        return teacherDTO;
    }
}
