package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.Teacher;
import com.barley.training.stub.biz.bean.client.TeacherDTO;
import com.barley.training.stub.biz.request.TeacherRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherConvertMapper {

    TeacherConvertMapper INSTANCE = Mappers.getMapper(TeacherConvertMapper.class);

    Teacher toEntity(TeacherRequest request);

    TeacherDTO toDTO(Teacher teacher);

    List<TeacherDTO> toDTOList(List<Teacher> teacher);
}
