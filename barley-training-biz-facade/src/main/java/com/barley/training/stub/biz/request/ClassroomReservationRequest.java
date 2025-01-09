package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Schema(description = "教室预定")
public class ClassroomReservationRequest {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "教室ID")
    private Long classroomId;

    @Schema(description = "预定时间")
    private LocalTime reservationTime;

    @Schema(description = "时长（分钟）")
    private Integer duration;

    @Schema(description = "预定周期 day、week、month")
    private String cycle;

    @Schema(description = "开始日期")
    private LocalDate startDate;

    @Schema(description = "结束日期")
    private LocalDate endDate;

    @Schema(description = "预订人")
    private String reserverName;

    @Schema(description = "预订人手机号")
    private String reserverPhone;

    @Schema(description = "用途")
    private String purpose;

    @Schema(description = "审核人ID")
    private Long approvalBy;

    @Schema(description = "审核人姓名")
    private String approvalName;

    @Schema(description = "审核状态")
    private String approvalStatus;

    @Schema(description = "备注")
    private String remarks;
}
