package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Menus extends BaseEntity implements Serializable {
    private Long id;
    private String parentCode;
    private String code;
    private String path;
    private String name;
    private String icon;
    private Integer sort;
}
