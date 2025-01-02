package com.barley.training.stub.biz.facade.admin;

import com.barley.training.stub.biz.request.ProjectFundsFlowRequest;
import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ProjectFundsFlowFacade", description = "项目资金流水")
public interface ProjectFundsFlowFacade {

    String URL = "/admin/project/funds/flow";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody ProjectFundsFlowRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
