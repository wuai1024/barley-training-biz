package com.barley.training.biz.entity.ext;

import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ArrayStringExt extends ArrayList<String> {
    public ArrayStringExt(List<String> dataList) {
        if (CollectionUtils.isNotEmpty(dataList)) {
            this.addAll(dataList);
        }
    }
}
