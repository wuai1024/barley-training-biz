package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "项目课程费")
public class CourseTeacherPriceRequest {

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "班级ID")
    private Long classId;

    @Schema(description = "老师ID")
    private Long teacherId;

    @Schema(description = "老师名称")
    private String teacherName;

    @Schema(description = "老师职称")
    private String teacherTitle;

    @Schema(description = "课时")
    private Long hour;

    @Schema(description = "课时薪酬")
    private BigDecimal salary;

    @Schema(description = "备注")
    private String remarks;
}
