package com.barley.training.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.ProjectFunds;
import com.barley.training.biz.entity.ProjectFundsFlow;
import com.barley.training.biz.mapper.ProjectFundsMapper;
import com.barley.training.biz.service.ProjectFundsService;
import com.barley.training.biz.service.convert.ProjectFundsConvertMapper;
import com.barley.training.stub.biz.request.ProjectFundsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class ProjectFundsServiceImpl extends ServiceImpl<ProjectFundsMapper, ProjectFunds> implements ProjectFundsService {

    @Override
    public boolean saveBy(ProjectFundsRequest request) {
        return this.saveOrUpdate(ProjectFundsConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(ProjectFunds::getIsDelete, true)
                .eq(ProjectFunds::getId, id)
                .last(LIMIT_1)
                .update();
    }

    @Override
    public void updateAmount(String flag, ProjectFundsFlow projectFundsFlow) {
        BigDecimal amount = BigDecimal.valueOf(0);
        if (Objects.equals(flag, "IN")) {
            amount = amount.subtract(projectFundsFlow.getAmount());
        } else if (Objects.equals(flag, "OUT")) {
            amount = amount.add(projectFundsFlow.getAmount());
        } else {
            return;
        }
        this.lambdaUpdate()
                .setSql("expenditure_amount = expenditure_amount + " + amount)
                .eq(ProjectFunds::getProjectId, projectFundsFlow.getProjectId())
                .eq(ProjectFunds::getClassId, projectFundsFlow.getClassId())
                .eq(ProjectFunds::getSubjectId, projectFundsFlow.getSubjectId())
                .last(LIMIT_1)
                .update();
    }
}
