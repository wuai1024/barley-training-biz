package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.ClassroomInfo;
import com.barley.training.stub.biz.request.ClassroomInfoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassroomInfoConvertMapper {

    ClassroomInfoConvertMapper INSTANCE = Mappers.getMapper(ClassroomInfoConvertMapper.class);

    ClassroomInfo toEntity(ClassroomInfoRequest request);
}
