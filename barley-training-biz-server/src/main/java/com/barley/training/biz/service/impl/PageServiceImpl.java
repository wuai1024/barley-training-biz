package com.barley.training.biz.service.impl;

import com.barley.common.base.JsonUtils;
import com.barley.training.biz.service.PageService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {
    @Override
    @SneakyThrows
    public Map<String, Object> get(String code) {
        code = code.toUpperCase().replaceAll("-", "_");
        try (InputStream inputStream = this.getClass().getResourceAsStream("/page/" + code + ".json")) {
            if (Objects.isNull(inputStream)) {
                return null;
            }
            return JsonUtils.parse(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8), new TypeReference<>() {
            });
        }
    }
}
