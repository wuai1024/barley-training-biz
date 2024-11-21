package com.barley.training.stub.biz.facade;

import com.barley.training.stub.biz.request.TeacherEvaluationRequest;
import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TeacherEvaluationFacade", description = "师资评估")
public interface TeacherEvaluationFacade {

    String URL = "/teacher/evaluation";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody TeacherEvaluationRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
