package com.barley.training.biz.controller.client;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.client.ProjectClassClientService;
import com.barley.training.stub.biz.bean.client.ProjectClassDTO;
import com.barley.training.stub.biz.facade.client.ProjectClassClientFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ProjectClassClientFacade.URL)
@RequiredArgsConstructor
public class ProjectClassClientController implements ProjectClassClientFacade {

    private final ProjectClassClientService projectClassClientService;


    @Override
    public ResponseData<List<ProjectClassDTO>> list() {
        return ResponseData.SUCCESS(projectClassClientService.getList());
    }

    @Override
    public ResponseData<ProjectClassDTO> getBy(long id) {
        return ResponseData.SUCCESS(projectClassClientService.getBy(id));
    }
}
