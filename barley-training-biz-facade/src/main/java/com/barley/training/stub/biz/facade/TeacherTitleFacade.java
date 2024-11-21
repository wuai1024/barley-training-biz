package com.barley.training.stub.biz.facade;

import com.barley.training.stub.biz.request.TeacherTitleRequest;
import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TeacherTitleFacade", description = "师资信息")
public interface TeacherTitleFacade {

    String URL = "/teacher/title";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody TeacherTitleRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
