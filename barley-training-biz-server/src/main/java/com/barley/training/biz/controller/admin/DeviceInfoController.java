package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.DeviceInfoService;
import com.barley.training.stub.biz.facade.admin.DeviceInfoFacade;
import com.barley.training.stub.biz.request.DeviceInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DeviceInfoFacade.URL)
@RequiredArgsConstructor
public class DeviceInfoController implements DeviceInfoFacade {
    private final DeviceInfoService deviceInfoService;


    @Override
    public ResponseData<Boolean> save(DeviceInfoRequest request) {
        return ResponseData.SUCCESS(deviceInfoService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(deviceInfoService.removeBy(id));
    }
}
