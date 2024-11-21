package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.ProjectFunds;
import com.barley.training.stub.biz.request.ProjectFundsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectFundsConvertMapper {

    ProjectFundsConvertMapper INSTANCE = Mappers.getMapper(ProjectFundsConvertMapper.class);

    ProjectFunds toEntity(ProjectFundsRequest request);
}
