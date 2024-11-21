package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.TeacherTitle;
import com.barley.training.stub.biz.request.TeacherTitleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherTitleConvertMapper {

    TeacherTitleConvertMapper INSTANCE = Mappers.getMapper(TeacherTitleConvertMapper.class);

    TeacherTitle toEntity(TeacherTitleRequest request);
}
