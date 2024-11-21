package com.barley.training.stub.biz.facade;

import com.barley.training.stub.biz.request.CourseRequest;
import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CourseFacade", description = "班级课程表")
public interface CourseFacade {

    String URL = "/course";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody CourseRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
