package com.barley.training.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.TeacherEvaluation;
import com.barley.training.biz.mapper.TeacherEvaluationMapper;
import com.barley.training.biz.service.TeacherEvaluationService;
import com.barley.training.biz.service.convert.TeacherEvaluationConvertMapper;
import com.barley.training.stub.biz.request.TeacherEvaluationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class TeacherEvaluationServiceImpl extends ServiceImpl<TeacherEvaluationMapper, TeacherEvaluation> implements TeacherEvaluationService {

    @Override
    public boolean saveBy(TeacherEvaluationRequest request) {
        return this.saveOrUpdate(TeacherEvaluationConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(TeacherEvaluation::getIsDelete, true)
                .eq(TeacherEvaluation::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
