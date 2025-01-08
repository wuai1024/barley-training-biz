package com.barley.training.biz.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.Course;
import com.barley.training.stub.biz.bean.admin.LiveDetailDTO;
import com.barley.training.stub.biz.request.CourseRequest;

public interface CourseService extends IService<Course> {

    boolean saveBy(CourseRequest request);

    boolean removeBy(long id);

    Boolean liveById(long id);

    LiveDetailDTO liveDetailById(long id);

    Boolean deleteLiveById(long id);
}
