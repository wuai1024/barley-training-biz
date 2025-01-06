package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Schema(description = "项目请求")
public class ProjectRequest {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "项目编号")
    private String projectCode;

    @Schema(description = "项目图片")
    private List<String> images;

    @Schema(description = "项目名称")
    private String projectName;

    @Schema(description = "开始时间")
    private LocalDate startDate;

    @Schema(description = "结束时间")
    private LocalDate endDate;

    @Schema(description = "项目简介")
    private String projectDescription;

    @Schema(description = "是否展示")
    private Boolean isDisplay;

    @Schema(description = "备注")
    private String remarks;
}
