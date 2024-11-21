package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.SysRole;
import com.barley.training.stub.biz.request.SysRoleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysRoleConvertMapper {

    SysRoleConvertMapper INSTANCE = Mappers.getMapper(SysRoleConvertMapper.class);

    SysRole toEntity(SysRoleRequest request);
}
