package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.DeviceInfo;
import com.barley.training.stub.biz.request.DeviceInfoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceInfoConvertMapper {

    DeviceInfoConvertMapper INSTANCE = Mappers.getMapper(DeviceInfoConvertMapper.class);

    DeviceInfo toEntity(DeviceInfoRequest request);
}