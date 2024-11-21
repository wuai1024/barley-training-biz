package com.barley.training.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.Teacher;
import com.barley.training.stub.biz.request.TeacherRequest;

public interface TeacherService extends IService<Teacher> {

    boolean saveBy(TeacherRequest request);

    boolean removeBy(long id);
}
