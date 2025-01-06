package com.barley.training.biz.service.client.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.DeviceInfo;
import com.barley.training.biz.mapper.DeviceInfoMapper;
import com.barley.training.biz.service.client.DeviceInfoClientService;
import com.barley.training.biz.service.convert.DeviceInfoConvertMapper;
import com.barley.training.stub.biz.bean.client.DeviceInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceInfoClientServiceImpl extends ServiceImpl<DeviceInfoMapper, DeviceInfo> implements DeviceInfoClientService {

    @Override
    public List<DeviceInfoDTO> getListById(List<Long> ids) {
        List<DeviceInfo> deviceInfos = this.lambdaQuery().in(DeviceInfo::getId, ids).list();
        return DeviceInfoConvertMapper.INSTANCE.toDTOList(deviceInfos);
    }

    @Override
    public List<DeviceInfoDTO> getList() {
        List<DeviceInfo> deviceInfos = this.lambdaQuery()
                .eq(DeviceInfo::getDeviceType, "S").list();
        return DeviceInfoConvertMapper.INSTANCE.toDTOList(deviceInfos);
    }
}
