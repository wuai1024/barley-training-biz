package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.TeacherCertificate;
import com.barley.training.stub.biz.bean.client.TeacherCertificateDTO;
import com.barley.training.stub.biz.request.TeacherCertificateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherCertificateConvertMapper {

    TeacherCertificateConvertMapper INSTANCE = Mappers.getMapper(TeacherCertificateConvertMapper.class);

    TeacherCertificate toEntity(TeacherCertificateRequest request);

    List<TeacherCertificateDTO> toDTOList(List<TeacherCertificate> teacherCertificate);

}
