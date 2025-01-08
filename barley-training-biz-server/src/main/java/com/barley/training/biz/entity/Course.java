package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import com.barley.training.biz.entity.ext.ArrayStringExt;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 班级课程
 */
@Setter
@Getter
public class Course extends BaseEntity implements Serializable {
    private Long id;  // ID

    private Long projectId;  // Project ID

    private Long classId;  // Class ID

    private Long teacherId;  // Teacher ID

    private Long classroomId;  // Classroom ID

    private String courseName;

    private Integer liveId;

    private String supervise;

    private String supervisePhone;

    private String trainingContent;  // Training content

    private String trainingForm;  // Training form

    private LocalDate date;  // Date of the course

    private String time;  // Time of the course

    private Integer hours;

    private ArrayStringExt files;
}
