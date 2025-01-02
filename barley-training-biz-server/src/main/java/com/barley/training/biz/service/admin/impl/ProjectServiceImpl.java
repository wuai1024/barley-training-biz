package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.Project;
import com.barley.training.biz.mapper.ProjectMapper;
import com.barley.training.biz.service.admin.ProjectService;
import com.barley.training.biz.service.convert.ProjectConvertMapper;
import com.barley.training.stub.biz.request.ProjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Override
    public boolean saveBy(ProjectRequest request) {
        return this.saveOrUpdate(ProjectConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(Project::getIsDelete, true)
                .eq(Project::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
