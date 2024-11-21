package com.barley.training.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.DeviceInfo;
import com.barley.training.stub.biz.request.DeviceInfoRequest;

public interface DeviceInfoService extends IService<DeviceInfo> {

    boolean saveBy(DeviceInfoRequest request);

    boolean removeBy(long id);
}
