package com.barley.training.biz.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.ProjectFunds;
import com.barley.training.biz.entity.ProjectFundsFlow;
import com.barley.training.stub.biz.request.ProjectFundsRequest;

public interface ProjectFundsService extends IService<ProjectFunds> {

    boolean saveBy(ProjectFundsRequest request);

    boolean removeBy(long id);

    void updateAmount(String flag, ProjectFundsFlow projectFundsFlow);
}
