package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Schema(description = "老师职称请求")
public class TeacherTitleRequest {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "职称代码")
    private String code;

    @Schema(description = "职称名称")
    private String name;

    @Schema(description = "职称薪酬配置")
    private List<Map<String, Object>> config;

    @Schema(description = "备注")
    private String remarks;
}
