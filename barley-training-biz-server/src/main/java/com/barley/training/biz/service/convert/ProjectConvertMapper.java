package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.Project;
import com.barley.training.stub.biz.request.ProjectRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectConvertMapper {

    ProjectConvertMapper INSTANCE = Mappers.getMapper(ProjectConvertMapper.class);

    Project toEntity(ProjectRequest request);
}
