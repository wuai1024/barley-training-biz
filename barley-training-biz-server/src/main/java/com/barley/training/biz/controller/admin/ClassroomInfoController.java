package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.ClassroomInfoService;
import com.barley.training.biz.service.client.InspectClientService;
import com.barley.training.stub.biz.bean.client.InspectDTO;
import com.barley.training.stub.biz.facade.admin.ClassroomInfoFacade;
import com.barley.training.stub.biz.request.ClassroomInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ClassroomInfoFacade.URL)
@RequiredArgsConstructor
public class ClassroomInfoController implements ClassroomInfoFacade {

    private final ClassroomInfoService classroomInfoService;
    private final InspectClientService inspectClientService;


    @Override
    public ResponseData<Boolean> save(ClassroomInfoRequest request) {
        return ResponseData.SUCCESS(classroomInfoService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(classroomInfoService.removeBy(id));
    }

    @Override
    public ResponseData<List<InspectDTO>> inspect() {
        return ResponseData.SUCCESS(inspectClientService.list());
    }
}
