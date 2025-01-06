package com.barley.training.stub.biz.bean.client;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 课程
 */
@Setter
@Getter
public class CourseDTO {
    private Long id;  // ID

    private Long projectId;  // Project ID
    private String projectName;  // Project ID

    private Long classId;  // Class ID
    private String className;  // Class ID

    private Long teacherId;  // Teacher ID
    private String teacherName;  // Teacher ID

    private Long classroomId;  // Classroom ID
    private String classroomName;  // Classroom ID

    private String supervise;

    private String supervisePhone;

    private String trainingContent;  // Training content

    private String trainingForm;  // Training form

    private LocalDate date;  // Date of the course

    private String time;  // Time of the course

    private Integer hours;

}
