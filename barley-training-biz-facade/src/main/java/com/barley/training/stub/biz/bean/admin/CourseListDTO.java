package com.barley.training.stub.biz.bean.admin;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseListDTO {

    private String key;
    private String label;
    private List<CourseListDTO> children;


}
