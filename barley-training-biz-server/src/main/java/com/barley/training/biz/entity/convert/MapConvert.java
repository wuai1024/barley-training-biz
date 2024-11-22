package com.barley.training.biz.entity.convert;

import com.barley.common.datasource.JsonTypeHandler;
import com.barley.training.biz.entity.ext.MapExt;

public class MapConvert extends JsonTypeHandler<MapExt> {
    @Override
    protected Class<MapExt> getSourceClass() {
        return MapExt.class;
    }
}
