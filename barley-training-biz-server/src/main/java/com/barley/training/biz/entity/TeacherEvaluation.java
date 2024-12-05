package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import com.barley.training.biz.entity.ext.ArrayStringExt;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 功能描述：
 *
 * @author wangganggang
 * @date 2024/10/8
 */
@Setter
@Getter
public class TeacherEvaluation extends BaseEntity implements Serializable {

    private Long id;
    private Long teacherId;
    private Long projectId;
    private LocalDate evaluationDate;
    private BigDecimal score;
    private String result;
    private ArrayStringExt images; // JSON representation
}
