package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.TeacherEvaluation;
import com.barley.training.stub.biz.request.TeacherEvaluationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherEvaluationConvertMapper {

    TeacherEvaluationConvertMapper INSTANCE = Mappers.getMapper(TeacherEvaluationConvertMapper.class);

    TeacherEvaluation toEntity(TeacherEvaluationRequest request);
}
