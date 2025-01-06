package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import com.barley.training.biz.entity.ext.ArrayLongExt;
import com.barley.training.biz.entity.ext.ArrayStringExt;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 教室信息
 */
@Setter
@Getter
public class ClassroomInfo extends BaseEntity implements Serializable {
    private Long id;

    private String name;

    private String code;

    private ArrayStringExt images;

    private Integer capacity;

    private String type;

    private ArrayLongExt device;
}