package com.barley.training.biz.controller.client;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.client.CourseClientService;
import com.barley.training.stub.biz.bean.client.CourseDTO;
import com.barley.training.stub.biz.bean.client.CourseViewDTO;
import com.barley.training.stub.biz.facade.client.CourseClientFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CourseClientFacade.URL)
@RequiredArgsConstructor
public class CourseClientController implements CourseClientFacade {

    private final CourseClientService courseClientService;

    @Override
    public ResponseData<List<CourseDTO>> list() {
        return ResponseData.SUCCESS(courseClientService.getList());
    }

    @Override
    public ResponseData<CourseDTO> getBy(long id) {
        return ResponseData.SUCCESS(courseClientService.getBy(id));
    }

    @Override
    public ResponseData<List<CourseViewDTO>> getViewBy(long id) {
        return ResponseData.SUCCESS(courseClientService.getViewBy(id));
    }

    @Override
    public ResponseData<CourseViewDTO> getLive() {
        return ResponseData.SUCCESS(courseClientService.getLive());
    }
}
