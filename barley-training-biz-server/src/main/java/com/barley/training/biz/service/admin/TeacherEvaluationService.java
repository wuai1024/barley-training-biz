package com.barley.training.biz.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.TeacherEvaluation;
import com.barley.training.stub.biz.request.TeacherEvaluationRequest;

public interface TeacherEvaluationService extends IService<TeacherEvaluation> {

    boolean saveBy(TeacherEvaluationRequest request);

    boolean removeBy(long id);
}
