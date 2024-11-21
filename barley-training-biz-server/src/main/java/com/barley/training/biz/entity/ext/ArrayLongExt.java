package com.barley.training.biz.entity.ext;

import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ArrayLongExt extends ArrayList<Long> {
    public ArrayLongExt(List<Long> dataList) {
        if (CollectionUtils.isNotEmpty(dataList)) {
            this.addAll(dataList);
        }
    }
}
