package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.SysUser;
import com.barley.training.stub.biz.request.SysUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserConvertMapper {

    SysUserConvertMapper INSTANCE = Mappers.getMapper(SysUserConvertMapper.class);

    SysUser toEntity(SysUserRequest request);
}
