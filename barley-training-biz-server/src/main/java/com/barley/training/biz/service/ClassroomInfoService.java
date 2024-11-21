package com.barley.training.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.ClassroomInfo;
import com.barley.training.stub.biz.request.ClassroomInfoRequest;

public interface ClassroomInfoService extends IService<ClassroomInfo> {

    boolean saveBy(ClassroomInfoRequest request);

    boolean removeBy(long id);
}
