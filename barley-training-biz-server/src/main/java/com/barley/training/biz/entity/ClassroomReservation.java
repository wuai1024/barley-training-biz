package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 教室预定表
 */
@Setter
@Getter
public class ClassroomReservation extends BaseEntity implements Serializable {
    private Long id;  // Primary Key

    private Long classroomId;  // ID of the classroom

    private LocalTime reservationTime;  // Reservation time

    private Integer duration;  // Duration in minutes

    private LocalDate startDate;  // Start date of the reservation

    private LocalDate endDate;  // End date of the reservation

    private String cycle;

    private String reserverName;  // Name of the reserver

    private String reserverPhone;  // Reserver's phone number

    private String purpose;  // Purpose of the reservation

    private Long approvalBy;  // ID of the approver

    private String approvalName;  // Name of the approver

    private String approvalStatus;  // Status of the approval

}