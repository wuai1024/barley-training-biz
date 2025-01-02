package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 学生信息
 */
@Setter
@Getter
public class Student extends BaseEntity implements Serializable {

    private Long id;
    private String code;
    private String name;
    private String gender;
    private String phone;
    private String remarks;
}
