package com.barley.training.stub.biz.facade.client;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.bean.client.TeacherDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "TeacherFacade", description = "教师信息")
public interface TeacherClientFacade {

    String URL = "/client/teacher";

    @GetMapping("/list")
    ResponseData<List<TeacherDTO>> list();

    @GetMapping("/{id}")
    ResponseData<TeacherDTO> getBy(@PathVariable long id);
}
