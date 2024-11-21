package com.barley.training.stub.biz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "教室信息")
public class ClassroomInfoRequest {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "教室名称")
    private String name;

    @Schema(description = "教室编号")
    private String code;

    @Schema(description = "教室容量")
    private Integer capacity;

    @Schema(description = "教室类型")
    private String type;

    @Schema(description = "教室配置")
    private List<Long> device;
}
