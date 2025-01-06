package com.barley.training.stub.biz.bean.client;

import lombok.Getter;
import lombok.Setter;

/**
 * 课程
 */
@Setter
@Getter
public class CourseViewDTO {
    private Long id;  // ID
    private String videoName; // 视频名称
    private String videoUrl; // 视频URL
}
