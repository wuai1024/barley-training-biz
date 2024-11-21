package com.barley.training.biz.entity;

import com.barley.training.biz.entity.ext.MapsExt;
import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 师资信息
 */
@Setter
@Getter
public class TeacherTitle extends BaseEntity implements Serializable {

    private Long id;
    private String code;
    private String name;
    private MapsExt config;

}