package com.barley.training.stub.biz.facade.client;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.bean.client.ClassroomInfoDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "ClassroomInfoFacade", description = "教室信息")
public interface ClassroomInfoClientFacade {

    String URL = "/client/classroom";

    @GetMapping("/list")
    ResponseData<List<ClassroomInfoDTO>> list();

    @GetMapping("/{id}")
    ResponseData<ClassroomInfoDTO> getBy(@PathVariable long id);

}
