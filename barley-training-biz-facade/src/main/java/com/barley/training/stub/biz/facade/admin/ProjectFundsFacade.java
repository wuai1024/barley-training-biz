package com.barley.training.stub.biz.facade.admin;

import com.barley.training.stub.biz.request.ProjectFundsRequest;
import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ProjectFundsFacade", description = "项目预算")
public interface ProjectFundsFacade {

    String URL = "/admin/project/funds";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody ProjectFundsRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
