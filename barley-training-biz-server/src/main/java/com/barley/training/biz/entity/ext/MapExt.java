package com.barley.training.biz.entity.ext;

import com.barley.common.base.JsonUtils;

import java.util.HashMap;
import java.util.Map;

public class MapExt extends HashMap<String, Object> {

    public MapExt() {
    }


    public MapExt(Map<String, Object> c) {
        super(c);
    }

    /**
     * Map 创建.
     *
     * @param value 对象.
     * @return Map 对象.
     */
    public static MapExt parse(Object value) {
        final MapExt map = new MapExt();
        map.putAll(JsonUtils.toMap(value));
        return map;
    }


    @Override
    public MapExt put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
