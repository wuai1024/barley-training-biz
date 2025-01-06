package com.barley.training.stub.biz.facade.client;

import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.bean.client.InspectDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Tag(name = "InspectFacade", description = "教室巡检")
public interface InspectClientFacade {

    String URL = "/client/inspect";

    @GetMapping("/list")
    ResponseData<List<InspectDTO>> list();

}
