package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import com.barley.training.biz.entity.ext.ArrayStringExt;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysRole extends BaseEntity {
    private Long id;
    private String name;
    private String description;
    private ArrayStringExt permissions;
}
