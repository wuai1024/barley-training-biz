package com.barley.training.stub.biz.facade.admin;

import com.barley.training.stub.biz.request.CourseSupervisionRequest;
import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CourseSupervisionFacade", description = "班级课程监督")
public interface CourseSupervisionFacade {

    String URL = "/admin/course/supervision";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody CourseSupervisionRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
