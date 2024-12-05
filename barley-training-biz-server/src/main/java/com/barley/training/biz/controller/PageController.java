package com.barley.training.biz.controller;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.PageService;
import com.barley.training.stub.biz.facade.PageFacade;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PageFacade.URL)
@RequiredArgsConstructor
public class PageController implements PageFacade {
    private final PageService pageService;

    @Override
    @SneakyThrows
    public ResponseData<?> get(String code) {
        return ResponseData.SUCCESS(pageService.get(code));
    }
}
