package com.barley.training.biz.controller.client;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.client.ClassroomInfoClientService;
import com.barley.training.stub.biz.bean.client.ClassroomInfoDTO;
import com.barley.training.stub.biz.facade.client.ClassroomInfoClientFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ClassroomInfoClientFacade.URL)
@RequiredArgsConstructor
public class ClassroomInfoClientController implements ClassroomInfoClientFacade {

    private final ClassroomInfoClientService classroomInfoClientService;


    @Override
    public ResponseData<List<ClassroomInfoDTO>> list() {
        return ResponseData.SUCCESS(classroomInfoClientService.getList());
    }

    @Override
    public ResponseData<ClassroomInfoDTO> getBy(long id) {
        return ResponseData.SUCCESS(classroomInfoClientService.getBy(id));
    }
}
