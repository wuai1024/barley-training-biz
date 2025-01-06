package com.barley.training.stub.biz.bean.client;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class TeacherEvaluationDTO {

    private Long id;
    private Long teacherId;
    private Long projectId;
    private LocalDate evaluationDate;
    private BigDecimal score;
    private String result;
    private List<String> images; // JSON representation
}
