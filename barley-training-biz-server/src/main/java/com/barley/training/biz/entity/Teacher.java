package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import com.barley.training.biz.entity.ext.ArrayStringExt;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 师资信息
 */
@Setter
@Getter
public class Teacher extends BaseEntity implements Serializable {
    private Long id;
    private String code;
    private String name;
    private ArrayStringExt images;
    private String inOutDept;
    private String organizationName;
    private String gender;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private String address;
    private Long titleId;
    private String education;
    private String educationalExperience;
    private String workExperience;
    private ArrayStringExt files;
}