package com.barley.training.biz.entity.convert;

import com.barley.training.biz.entity.ext.ArrayStringExt;
import com.barley.common.datasource.JsonTypeHandler;

public class ArrayStringConvert extends JsonTypeHandler<ArrayStringExt> {
    @Override
    protected Class<ArrayStringExt> getSourceClass() {
        return ArrayStringExt.class;
    }
}
