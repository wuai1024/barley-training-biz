package com.barley.training.biz.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.CourseSupervision;
import com.barley.training.stub.biz.request.CourseSupervisionRequest;

public interface CourseSupervisionService extends IService<CourseSupervision> {

    boolean saveBy(CourseSupervisionRequest request);

    boolean removeBy(long id);
}
