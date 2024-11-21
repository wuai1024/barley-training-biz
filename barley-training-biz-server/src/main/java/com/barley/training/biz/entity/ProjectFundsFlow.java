package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;


@Setter
@Getter
public class ProjectFundsFlow extends BaseEntity implements Serializable {

    private Long id;
    private Long projectId;
    private String projectName;
    private Long classId;
    private String className;
    private Long subjectId;
    private String subjectName;
    private String transactionType;
    private BigDecimal amount;
    private String remarks;
}