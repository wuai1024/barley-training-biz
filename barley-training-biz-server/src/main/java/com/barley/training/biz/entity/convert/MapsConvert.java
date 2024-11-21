package com.barley.training.biz.entity.convert;

import com.barley.training.biz.entity.ext.MapsExt;
import com.barley.common.datasource.JsonArrayTypeHandler;

public class MapsConvert extends JsonArrayTypeHandler<MapsExt> {
    @Override
    protected Class<MapsExt> getSourceClass() {
        return MapsExt.class;
    }
}
