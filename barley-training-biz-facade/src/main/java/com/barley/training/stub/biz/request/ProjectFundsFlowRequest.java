package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "项目预算")
public class ProjectFundsFlowRequest {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "培训班ID")
    private Long classId;

    @Schema(description = "科目ID")
    private Long subjectId;

    @Schema(description = "金额")
    private BigDecimal amount;

    @Schema(description = "日期")
    private LocalDateTime transactionDate;

    @Schema(description = "备注")
    private String remarks;
}
