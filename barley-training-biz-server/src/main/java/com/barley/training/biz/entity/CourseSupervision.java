package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 设备信息
 */
@Setter
@Getter
public class CourseSupervision extends BaseEntity implements Serializable {

    private Long id;

    private Long projectId;

    private Long courseId;

    private String name;

    private Boolean sex;  // Gender (1 for male, 0 for female)

    private String phone;

    private String trainingContent;

    private String trainingForm;

    private LocalDate date;

    private LocalTime time;

    private Integer rating;

    private String comments;

}