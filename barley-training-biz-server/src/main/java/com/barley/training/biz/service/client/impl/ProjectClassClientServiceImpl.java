package com.barley.training.biz.service.client.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.ProjectClass;
import com.barley.training.biz.mapper.ProjectClassMapper;
import com.barley.training.biz.service.client.ProjectClassClientService;
import com.barley.training.biz.service.convert.ProjectClassConvertMapper;
import com.barley.training.stub.biz.bean.client.ProjectClassDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProjectClassClientServiceImpl extends ServiceImpl<ProjectClassMapper, ProjectClass> implements ProjectClassClientService {

    @Override
    public List<ProjectClassDTO> getList() {
        List<ProjectClass> projectClasses = this.lambdaQuery().list();
        if (CollectionUtils.isEmpty(projectClasses)) {
            return Collections.emptyList();
        }
        return ProjectClassConvertMapper.INSTANCE.toDTOList(projectClasses);
    }

    @Override
    public ProjectClassDTO getBy(long id) {
        ProjectClass projectClass = this.lambdaQuery().eq(ProjectClass::getId, id).one();
        if (Objects.nonNull(projectClass)) {
            return ProjectClassConvertMapper.INSTANCE.toDTO(projectClass);
        }
        return null;
    }
}
