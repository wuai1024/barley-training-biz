package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 师资信息
 */
@Setter
@Getter
public class TeacherCertificate extends BaseEntity implements Serializable {
    private Long id;
    private Long teacherId;
    private String certificateCode;
    private String certificateName;
    private String issuingAuthority;
    private LocalDate acquisitionDate;
    private String images; // JSON representation
}