package com.barley.training.biz.controller;

import com.barley.common.base.response.PageData;
import com.barley.common.base.response.ResponseData;
import com.barley.common.datasource.SearchRequest;
import com.barley.common.datasource.service.LocalQueryCacheService;
import com.barley.training.stub.biz.facade.QueryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(QueryFacade.URL)
@RequiredArgsConstructor
public class QueryController implements QueryFacade {

    private final LocalQueryCacheService queryService;

    @Override
    public ResponseData<PageData<?>> search(String code, SearchRequest request) {
        return ResponseData.SUCCESS(queryService.queryPage(code, request));
    }

    @Override
    public ResponseData<List<?>> list(String code, HashMap<String, Object> request) {
        return ResponseData.SUCCESS(queryService.queryList(code, request));
    }

    @Override
    public ResponseData<?> get(String code, HashMap<String, Object> request) {
        return ResponseData.SUCCESS(queryService.queryOne(code, request));
    }
}

