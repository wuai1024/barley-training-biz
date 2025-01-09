package com.barley.training.stub.biz.facade.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.request.ProjectRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ProjectFacade", description = "项目信息")
public interface ProjectFacade {

    String URL = "/admin/project";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody ProjectRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
