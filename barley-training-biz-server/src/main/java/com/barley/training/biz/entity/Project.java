package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Setter
@Getter
public class Project extends BaseEntity implements Serializable {
    private Long id;
    private String projectCode;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDescription;
    private Boolean isDisplay;
}