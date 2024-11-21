package com.barley.training.stub.biz.facade;

import com.barley.training.stub.biz.request.DeviceInfoRequest;
import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "DeviceInfoFacade", description = "设备信息")
public interface DeviceInfoFacade {

    String URL = "/device-info";

    @PostMapping("/save")
    @Operation(summary = "保存")
    ResponseData<Boolean> save(@RequestBody DeviceInfoRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    ResponseData<Boolean> deleteById(@PathVariable("id") long id);
}
