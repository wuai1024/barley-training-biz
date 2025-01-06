package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "项目班级")
public class ProjectClassRequest {

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "班级")
    private String className;

    @Schema(description = "班级图片")
    private List<String> images;

    @Schema(description = "班主任")
    private String classHeader;

    @Schema(description = "班主任电话")
    private String classHeaderPhone;

    @Schema(description = "班长")
    private String classLeader;

    @Schema(description = "班长电话")
    private String classLeaderPhone;

    @Schema(description = "学习委员")
    private String studyCommittee;

    @Schema(description = "学习委员电话")
    private String studyCommitteePhone;

    @Schema(description = "宣传委员")
    private String publicityCommittee;

    @Schema(description = "宣传委员电话")
    private String publicityCommitteePhone;

    @Schema(description = "纪律委员")
    private String disciplineCommittee;

    @Schema(description = "纪律委员电话")
    private String disciplineCommitteePhone;

    @Schema(description = "生活委员")
    private String lifeCommittee;

    @Schema(description = "生活委员电话")
    private String lifeCommitteePhone;

    @Schema(description = "临时书记")
    private String temporarySecretary;

    @Schema(description = "临时书记电话")
    private String temporarySecretaryPhone;

    @Schema(description = "备注")
    private String remarks;
}
