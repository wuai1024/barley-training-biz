package com.barley.training.stub.biz.bean.client;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * 师资信息
 */
@Setter
@Getter
public class TeacherDTO {
    private Long id;
    private String code;
    private String name;
    private List<String> images;
    private String inOutDept;
    private String organizationName;
    private String gender;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private String address;
    private Long titleId;
    private String titleName;
    private String education;
    private String educationalExperience;
    private String workExperience;

    private List<TeacherCertificateDTO> certificateDTOS;
}