package com.barley.training.stub.biz.facade.client;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.bean.client.CourseDTO;
import com.barley.training.stub.biz.bean.client.CourseViewDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "CourseFacade", description = "班级课程表")
public interface CourseClientFacade {

    String URL = "/client/course";

    @GetMapping("/list")
    ResponseData<List<CourseDTO>> list();

    @GetMapping("/{id}")
    ResponseData<CourseDTO> getBy(@PathVariable long id);

    @GetMapping("/view/{id}")
    ResponseData<List<CourseViewDTO>> getViewBy(@PathVariable long id);

    @GetMapping("/live")
    ResponseData<CourseViewDTO> getLive();


}
