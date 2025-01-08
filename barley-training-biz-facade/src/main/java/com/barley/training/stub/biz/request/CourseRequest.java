package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Schema(description = "班级课程")
public class CourseRequest {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "班级ID")
    private Long classId;

    @Schema(description = "老师ID")
    private Long teacherId;

    @Schema(description = "教室ID")
    private Long classroomId;

    @Schema(description = "课程名称")
    private String courseName;

    @Schema(description = "督导员")
    private String supervise;

    @Schema(description = "督导电话")
    private String supervisePhone;

    @Schema(description = "培训内容")
    private String trainingContent;

    @Schema(description = "培训形式")
    private String trainingForm;

    @Schema(description = "日期")
    private LocalDate date;

    @Schema(description = "时间")
    private String time;

    @Schema(description = "课时")
    private Integer hours;

    @Schema(description = "附件")
    private List<String> files;

    @Schema(description = "备注")
    private String remarks;
}
