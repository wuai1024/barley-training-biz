package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.ProjectFundsFlow;
import com.barley.training.stub.biz.request.ProjectFundsFlowRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectFundsFlowConvertMapper {

    ProjectFundsFlowConvertMapper INSTANCE = Mappers.getMapper(ProjectFundsFlowConvertMapper.class);

    ProjectFundsFlow toEntity(ProjectFundsFlowRequest request);
}
