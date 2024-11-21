package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "设备信息")
public class DeviceInfoRequest {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "设备名称")
    private String deviceName;

    @Schema(description = "设备代码")
    private String deviceCode;

    @Schema(description = "设备类型")
    private String deviceType;

    @Schema(description = "设备IP")
    private String deviceIp;

    @Schema(description = "设备型号")
    private String model;

    @Schema(description = "设备型号")
    private String serialNumber;

    @Schema(description = "采购日期")
    private LocalDateTime purchaseDate;

    @Schema(description = "附件")
    private List<String> images;

    @Schema(description = "备注")
    private String remarks;
}
