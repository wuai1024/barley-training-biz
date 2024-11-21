package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.CourseSupervision;
import com.barley.training.stub.biz.request.CourseSupervisionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseSupervisionConvertMapper {

    CourseSupervisionConvertMapper INSTANCE = Mappers.getMapper(CourseSupervisionConvertMapper.class);

    CourseSupervision toEntity(CourseSupervisionRequest request);
}
