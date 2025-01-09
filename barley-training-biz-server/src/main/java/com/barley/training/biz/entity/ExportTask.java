package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import com.barley.training.biz.entity.ext.MapExt;
import lombok.*;

@Setter
@Getter
@ToString
public class ExportTask extends BaseEntity {
    /**
     * ID.
     */
    private Long id;
    /**
     * 页面ID.
     */
    private String pageCode;
    /**
     * 导出配置ID.
     */
    private String exportConfigCode;
    /**
     * 名称.
     */
    private String name;
    /**
     * 参数.
     */
    private MapExt params;
    /**
     * 下载地址.
     */
    private String url;
    /**
     * 状态.
     */
    private Integer status;
    /**
     * 消息.
     */
    private String message;
}
