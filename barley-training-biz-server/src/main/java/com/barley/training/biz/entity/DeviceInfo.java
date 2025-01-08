package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import com.barley.training.biz.entity.ext.ArrayStringExt;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 设备信息
 */
@Setter
@Getter
public class DeviceInfo extends BaseEntity implements Serializable {
    private Long id;
    private Integer thirdId;
    private String deviceName;
    private String deviceCode;
    private String deviceIp;
    private String deviceType;
    private String model;
    private String serialNumber;
    private LocalDateTime purchaseDate;
    private ArrayStringExt images;
}