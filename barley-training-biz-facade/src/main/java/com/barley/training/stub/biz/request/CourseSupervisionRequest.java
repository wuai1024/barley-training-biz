package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Schema(description = "班级课程监督")
public class CourseSupervisionRequest {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "课程ID")
    private Long courseId;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "性别")
    private Boolean sex;  // 1 for male, 0 for female

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "培训内容")
    private String trainingContent;

    @Schema(description = "培训形式")
    private String trainingForm;

    @Schema(description = "日期")
    private LocalDate date;

    @Schema(description = "时间")
    private LocalTime time;

    @Schema(description = "评分")
    private Integer rating;

    @Schema(description = "评论")
    private String comments;

    @Schema(description = "备注")
    private String remarks;
}
