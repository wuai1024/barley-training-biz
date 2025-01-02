package com.barley.training.stub.biz.bean.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExportTaskDTO {
    @Schema(description = "ID")
    private Long id;
    @Schema(description = "名称")
    private String name;
    @Schema(description = "路径")
    private String url;
    @Schema(description = "状态")
    private Integer status;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
