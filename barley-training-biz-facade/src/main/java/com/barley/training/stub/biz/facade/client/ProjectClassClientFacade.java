package com.barley.training.stub.biz.facade.client;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.bean.client.ProjectClassDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "ProjectClassFacade", description = "培训班")
public interface ProjectClassClientFacade {

    String URL = "/client/project/class";

    @GetMapping("/list")
    ResponseData<List<ProjectClassDTO>> list();

    @GetMapping("/{id}")
    ResponseData<ProjectClassDTO> getBy(@PathVariable long id);
}
