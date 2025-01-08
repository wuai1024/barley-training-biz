package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.channel.ItcApis;
import com.barley.training.biz.channel.response.DeviceListResponse;
import com.barley.training.biz.entity.DeviceInfo;
import com.barley.training.biz.mapper.DeviceInfoMapper;
import com.barley.training.biz.service.admin.DeviceInfoService;
import com.barley.training.biz.service.convert.DeviceInfoConvertMapper;
import com.barley.training.stub.biz.request.DeviceInfoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Log4j2
@Service
@RequiredArgsConstructor
public class DeviceInfoServiceImpl extends ServiceImpl<DeviceInfoMapper, DeviceInfo> implements DeviceInfoService {

    private final ItcApis itcApis;

    @Override
    public boolean saveBy(DeviceInfoRequest request) {
        DeviceInfo entity = DeviceInfoConvertMapper.INSTANCE.toEntity(request);
        try {
            DeviceListResponse deviceListResponse = itcApis.deviceList();
            deviceListResponse.getData().getData().forEach(device -> {
                if (device.getIp().equals(request.getDeviceIp())) {
                    entity.setThirdId(device.getId());
                }
            });
        } catch (Exception e) {
            log.error("[设备获取] 失败: {}", e.getMessage(), e);
        }
        return this.saveOrUpdate(entity);
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(DeviceInfo::getIsDelete, true).eq(DeviceInfo::getId, id).last(LIMIT_1).update();
    }
}
