package com.barley.training.biz.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.ProjectClass;
import com.barley.training.stub.biz.request.ProjectClassRequest;

public interface ProjectClassService extends IService<ProjectClass> {

    boolean saveBy(ProjectClassRequest request);

    boolean removeBy(long id);
}
