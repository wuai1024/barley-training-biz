package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Schema(description = "老师请求")
public class TeacherRequest {

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "老师代码")
    private String code;

    @Schema(description = "老师名称")
    private String name;

    @Schema(description = "头像")
    private List<String> images;

    @Schema(description = "内外部")
    private String inOutDept;

    @Schema(description = "单位名称")
    private String organizationName;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "出生日期")
    private LocalDate birthDate;

    @Schema(description = "电话号码")
    private String phone;

    @Schema(description = "电子邮件")
    private String email;

    @Schema(description = "家庭地址")
    private String address;

    @Schema(description = "职称 ID")
    private Long titleId;

    @Schema(description = "学历")
    private String education;

    @Schema(description = "教育经历")
    private String educationalExperience;

    @Schema(description = "工作经历")
    private String workExperience;

    @Schema(description = "附件")
    private List<String> files;

    @Schema(description = "备注")
    private String remarks;
}
