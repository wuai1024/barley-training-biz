package com.barley.training.biz.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.Project;
import com.barley.training.stub.biz.request.ProjectRequest;

public interface ProjectService extends IService<Project> {

    boolean saveBy(ProjectRequest request);

    boolean removeBy(long id);
}
