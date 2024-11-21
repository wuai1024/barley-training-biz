package com.barley.training.biz.controller;

import com.barley.common.base.JsonUtils;
import com.barley.common.base.response.ResponseData;
import com.barley.training.stub.biz.facade.PageFacade;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@RestController
@RequestMapping(PageFacade.URL)
@RequiredArgsConstructor
public class PageController implements PageFacade {
    @Override
    @SneakyThrows
    public ResponseData<?> get(String code) {
        code = code.toUpperCase().replaceAll("-", "_");
        try (InputStream inputStream = this.getClass().getResourceAsStream("/page/" + code + ".json")) {
            if (Objects.isNull(inputStream)) {
                return ResponseData.SUCCESS();
            }
            return ResponseData.SUCCESS(JsonUtils.parse(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8)));
        }
    }
}
