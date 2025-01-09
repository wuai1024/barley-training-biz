package com.barley.training.stub.biz.facade.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.bean.client.InspectDTO;
import com.barley.training.stub.biz.request.ClassroomInfoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "ClassroomInfoFacade", description = "教室信息")
public interface ClassroomInfoFacade {

    String URL = "/admin/classroom";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody ClassroomInfoRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);

    @GetMapping("/inspect")
    @Operation(summary = "课堂巡检")
    ResponseData<List<InspectDTO>> inspect();
}
