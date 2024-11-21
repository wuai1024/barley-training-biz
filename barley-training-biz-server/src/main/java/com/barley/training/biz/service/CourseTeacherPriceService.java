package com.barley.training.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.CourseTeacherPrice;
import com.barley.training.stub.biz.request.CourseTeacherPriceRequest;

public interface CourseTeacherPriceService extends IService<CourseTeacherPrice> {

    boolean saveBy(CourseTeacherPriceRequest request);

    boolean removeBy(long id);
}
