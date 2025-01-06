package com.barley.training.biz.service.client;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.DeviceInfo;
import com.barley.training.stub.biz.bean.client.DeviceInfoDTO;

import java.util.List;


public interface DeviceInfoClientService extends IService<DeviceInfo> {

    List<DeviceInfoDTO> getListById(List<Long> ids);

    List<DeviceInfoDTO> getList();

}
