package com.barley.training.stub.biz.bean.client;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 教室信息
 */
@Setter
@Getter
public class ClassroomInfoDTO {
    private Long id;

    private String name;

    private String code;

    private Integer capacity;

    private String type;

    private List<String> images;

    private List<DeviceInfoDTO> deviceInfoDTOS;
}