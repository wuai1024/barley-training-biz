package com.barley.training.stub.biz.facade.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.bean.admin.*;
import com.barley.training.stub.biz.request.CourseRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "CourseFacade", description = "班级课程表")
public interface CourseFacade {

    String URL = "/admin/course";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody CourseRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);

    @GetMapping("/list/{id}")
    @Operation(summary = "课程列表")
    ResponseData<List<CourseListDTO>> listByProject(@PathVariable("id") long id);

    @GetMapping("/video/{id}")
    @Operation(summary = "课程回放视频")
    ResponseData<List<CourseViewDTO>> videoByCourseId(@PathVariable("id") long id);

    @GetMapping("/live/{id}")
    @Operation(summary = "预约录播")
    ResponseData<Boolean> liveById(@PathVariable("id") long id);

    @DeleteMapping("/live/{id}")
    @Operation(summary = "取消预约录播")
    ResponseData<Boolean> deleteLiveById(@PathVariable("id") long id);

    @GetMapping("/live/detail/{id}")
    @Operation(summary = "预约录播详情")
    ResponseData<LiveDetailDTO> liveDetailById(@PathVariable("id") long id);


}
