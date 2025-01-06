package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.DeviceInfo;
import com.barley.training.stub.biz.bean.client.DeviceInfoDTO;
import com.barley.training.stub.biz.request.DeviceInfoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DeviceInfoConvertMapper {

    DeviceInfoConvertMapper INSTANCE = Mappers.getMapper(DeviceInfoConvertMapper.class);

    DeviceInfo toEntity(DeviceInfoRequest request);

    List<DeviceInfoDTO> toDTOList(List<DeviceInfo> deviceInfo);
}
