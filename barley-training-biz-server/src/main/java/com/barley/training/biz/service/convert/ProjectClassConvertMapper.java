package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.ProjectClass;
import com.barley.training.stub.biz.request.ProjectClassRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectClassConvertMapper {

    ProjectClassConvertMapper INSTANCE = Mappers.getMapper(ProjectClassConvertMapper.class);

    ProjectClass toEntity(ProjectClassRequest request);
}
