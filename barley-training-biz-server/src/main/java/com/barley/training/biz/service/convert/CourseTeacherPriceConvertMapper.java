package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.CourseTeacherPrice;
import com.barley.training.stub.biz.request.CourseTeacherPriceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseTeacherPriceConvertMapper {

    CourseTeacherPriceConvertMapper INSTANCE = Mappers.getMapper(CourseTeacherPriceConvertMapper.class);

    CourseTeacherPrice toEntity(CourseTeacherPriceRequest request);
}
