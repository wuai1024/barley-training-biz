package com.barley.training.biz.controller.client;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.client.TeacherClientService;
import com.barley.training.stub.biz.bean.client.TeacherDTO;
import com.barley.training.stub.biz.facade.client.TeacherClientFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(TeacherClientFacade.URL)
@RequiredArgsConstructor
public class TeacherClientController implements TeacherClientFacade {

    private final TeacherClientService teacherClientService;


    @Override
    public ResponseData<List<TeacherDTO>> list() {
        return ResponseData.SUCCESS(teacherClientService.getList());
    }

    @Override
    public ResponseData<TeacherDTO> getBy(long id) {
        return ResponseData.SUCCESS(teacherClientService.getBy(id));
    }
}
