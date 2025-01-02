package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.DeviceInfo;
import com.barley.training.biz.mapper.DeviceInfoMapper;
import com.barley.training.biz.service.admin.DeviceInfoService;
import com.barley.training.biz.service.convert.DeviceInfoConvertMapper;
import com.barley.training.stub.biz.request.DeviceInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class DeviceInfoServiceImpl extends ServiceImpl<DeviceInfoMapper, DeviceInfo> implements DeviceInfoService {

    @Override
    public boolean saveBy(DeviceInfoRequest request) {
        return this.saveOrUpdate(DeviceInfoConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(DeviceInfo::getIsDelete, true)
                .eq(DeviceInfo::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
