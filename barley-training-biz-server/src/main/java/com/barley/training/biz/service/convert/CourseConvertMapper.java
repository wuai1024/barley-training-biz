package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.Course;
import com.barley.training.stub.biz.request.CourseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseConvertMapper {

    CourseConvertMapper INSTANCE = Mappers.getMapper(CourseConvertMapper.class);

    Course toEntity(CourseRequest request);
}
