package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "老师测评请求")
public class TeacherEvaluationRequest {

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "老师ID")
    private Long teacherId;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "测评日期")
    private LocalDate evaluationDate;

    @Schema(description = "得分")
    private BigDecimal score;

    @Schema(description = "结果")
    private String result;

    @Schema(description = "图片 JSON")
    private String images; // JSON representation

    @Schema(description = "备注")
    private String remarks;
}
