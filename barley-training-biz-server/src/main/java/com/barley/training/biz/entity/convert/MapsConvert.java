package com.barley.training.biz.entity.convert;

import com.barley.common.datasource.JsonArrayTypeHandler;
import com.barley.training.biz.entity.ext.MapsExt;

public class MapsConvert extends JsonArrayTypeHandler<MapsExt> {
    @Override
    protected Class<MapsExt> getSourceClass() {
        return MapsExt.class;
    }
}
