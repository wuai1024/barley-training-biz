package com.barley.training.biz.controller.client;


import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.client.InspectClientService;
import com.barley.training.stub.biz.bean.client.InspectDTO;
import com.barley.training.stub.biz.facade.client.InspectClientFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(InspectClientFacade.URL)
@RequiredArgsConstructor
public class InspectClientController implements InspectClientFacade {

    private final InspectClientService inspectClientService;

    @Override
    public ResponseData<List<InspectDTO>> list() {
        return ResponseData.SUCCESS(inspectClientService.list());
    }
}
