package com.barley.training.biz.entity.convert;

import com.barley.common.datasource.JsonTypeHandler;
import com.barley.training.biz.entity.ext.ArrayStringExt;

public class ArrayStringConvert extends JsonTypeHandler<ArrayStringExt> {
    @Override
    protected Class<ArrayStringExt> getSourceClass() {
        return ArrayStringExt.class;
    }
}
