package com.barley.training.stub.biz.facade.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.request.ClassroomReservationRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ClassroomReservationFacade", description = "教室预定")
public interface ClassroomReservationFacade {

    String URL = "/admin/classroom/reservation";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody ClassroomReservationRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
