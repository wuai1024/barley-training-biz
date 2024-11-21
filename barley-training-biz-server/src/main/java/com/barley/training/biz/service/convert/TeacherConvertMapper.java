package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.Teacher;
import com.barley.training.stub.biz.request.TeacherRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherConvertMapper {

    TeacherConvertMapper INSTANCE = Mappers.getMapper(TeacherConvertMapper.class);

    Teacher toEntity(TeacherRequest request);
}
