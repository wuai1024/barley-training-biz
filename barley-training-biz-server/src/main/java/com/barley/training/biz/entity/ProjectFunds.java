package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;


@Setter
@Getter
public class ProjectFunds extends BaseEntity implements Serializable {

    private Long id;
    private Long projectId;
    private Long classId;
    private Long subjectId;
    private BigDecimal totalAmount;
    private BigDecimal expenditureAmount;
    private BigDecimal amount;
    private String remarks;
}