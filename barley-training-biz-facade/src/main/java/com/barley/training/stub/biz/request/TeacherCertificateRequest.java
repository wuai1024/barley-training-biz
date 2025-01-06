package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Schema(description = "老师证书请求")
public class TeacherCertificateRequest {

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "老师ID")
    private Long teacherId;

    @Schema(description = "证书代码")
    private String certificateCode;

    @Schema(description = "证书名称")
    private String certificateName;

    @Schema(description = "颁发机构")
    private String issuingAuthority;

    @Schema(description = "获取日期")
    private LocalDate acquisitionDate;

    @Schema(description = "照片 JSON")
    private List<String> images; // JSON representation

    @Schema(description = "备注")
    private String remarks;
}
