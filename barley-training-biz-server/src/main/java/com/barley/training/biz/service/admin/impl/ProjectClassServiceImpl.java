package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.ProjectClass;
import com.barley.training.biz.mapper.ProjectClassMapper;
import com.barley.training.biz.service.admin.ProjectClassService;
import com.barley.training.biz.service.convert.ProjectClassConvertMapper;
import com.barley.training.stub.biz.request.ProjectClassRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class ProjectClassServiceImpl extends ServiceImpl<ProjectClassMapper, ProjectClass> implements ProjectClassService {

    @Override
    public boolean saveBy(ProjectClassRequest request) {
        return this.saveOrUpdate(ProjectClassConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(ProjectClass::getIsDelete, true)
                .eq(ProjectClass::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
