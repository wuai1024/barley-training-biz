package com.barley.training.stub.biz.bean.client;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 师资信息
 */
@Setter
@Getter
public class TeacherCertificateDTO {
    private Long id;
    private Long teacherId;
    private String certificateCode;
    private String certificateName;
    private String issuingAuthority;
    private LocalDate acquisitionDate;
}