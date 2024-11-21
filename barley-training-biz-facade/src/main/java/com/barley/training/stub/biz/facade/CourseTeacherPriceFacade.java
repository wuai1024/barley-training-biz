package com.barley.training.stub.biz.facade;

import com.barley.training.stub.biz.request.CourseTeacherPriceRequest;
import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CourseTeacherPriceFacade", description = "教师薪酬计算")
public interface CourseTeacherPriceFacade {

    String URL = "/course/teacher-price";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody CourseTeacherPriceRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
