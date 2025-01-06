package com.barley.training.stub.biz.bean.client;

import lombok.Getter;
import lombok.Setter;

/**
 * 设备信息
 */
@Setter
@Getter
public class DeviceInfoDTO {
    private Long id;
    private String deviceName;
    private String deviceCode;
    private String deviceType;
}