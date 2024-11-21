package com.barley.training.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.*;
import com.barley.training.biz.mapper.*;
import com.barley.training.biz.service.ProjectFundsFlowService;
import com.barley.training.biz.service.ProjectFundsService;
import com.barley.training.biz.service.convert.ProjectFundsFlowConvertMapper;
import com.barley.training.stub.biz.request.ProjectFundsFlowRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class ProjectFundsFlowServiceImpl extends ServiceImpl<ProjectFundsFlowMapper, ProjectFundsFlow> implements ProjectFundsFlowService {

    private final ProjectMapper projectMapper;
    private final ProjectClassMapper projectClassMapper;
    private final ProjectFundsService projectFundsService;

    @Override
    public boolean saveBy(ProjectFundsFlowRequest request) {
        ProjectFundsFlow entity = ProjectFundsFlowConvertMapper.INSTANCE.toEntity(request);
        Project project = projectMapper.selectById(request.getProjectId());
        ProjectClass projectClass = projectClassMapper.selectById(request.getClassId());
        entity.setProjectName(Optional.ofNullable(project.getProjectName()).orElse(""));
        entity.setClassName(Optional.ofNullable(projectClass.getClassName()).orElse(""));
        boolean flag = this.saveOrUpdate(entity);
        projectFundsService.updateAmount("OUT", entity);
        return flag;
    }

    @Override
    public boolean removeBy(long id) {
        ProjectFundsFlow entity = this.getById(id);
        projectFundsService.updateAmount("IN", entity);
        return this.lambdaUpdate().set(ProjectFundsFlow::getIsDelete, true)
                .eq(ProjectFundsFlow::getId, id)
                .last(LIMIT_1)
                .update();
    }


}
