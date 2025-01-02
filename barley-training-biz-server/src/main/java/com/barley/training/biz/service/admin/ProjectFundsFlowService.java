package com.barley.training.biz.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.ProjectFundsFlow;
import com.barley.training.stub.biz.request.ProjectFundsFlowRequest;

public interface ProjectFundsFlowService extends IService<ProjectFundsFlow> {

    boolean saveBy(ProjectFundsFlowRequest request);

    boolean removeBy(long id);
}
