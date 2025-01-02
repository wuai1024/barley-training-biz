package com.barley.training.stub.biz.facade.admin;

import com.barley.training.stub.biz.request.TeacherCertificateRequest;
import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TeacherTitleFacade", description = "师资信息")
public interface TeacherCertificateFacade {

    String URL = "/admin/teacher/certificate";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody TeacherCertificateRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
