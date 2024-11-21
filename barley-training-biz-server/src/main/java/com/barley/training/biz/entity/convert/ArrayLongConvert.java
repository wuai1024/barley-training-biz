package com.barley.training.biz.entity.convert;

import com.barley.training.biz.entity.ext.ArrayLongExt;
import com.barley.common.datasource.JsonTypeHandler;

public class ArrayLongConvert extends JsonTypeHandler<ArrayLongExt> {
    @Override
    protected Class<ArrayLongExt> getSourceClass() {
        return ArrayLongExt.class;
    }
}
