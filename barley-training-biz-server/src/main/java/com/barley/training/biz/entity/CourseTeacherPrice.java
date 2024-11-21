package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 设备信息
 */
@Setter
@Getter
public class CourseTeacherPrice extends BaseEntity implements Serializable {

    private Long id;  // ID

    private Long projectId;  // Project ID

    private Long classId;  // Class ID

    private Long teacherId;  // Teacher ID

    private String teacherName;  // Teacher Name

    private String teacherTitle;  // Teacher Title

    private Long hour;  // Class Hours

    private BigDecimal salary;  // Salary per Class Hour

}