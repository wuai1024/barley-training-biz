package com.barley.training.biz.entity.ext;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class MapsExt extends ArrayList<MapExt> {

    public MapsExt(@NotNull Collection<? extends Map<String, Object>> c) {
        super(c.stream().map(MapExt::new).toList());
    }

    /**
     * 创建通过List.
     *
     * @param items 明细.
     * @return Maps 数据.
     */
    public static MapsExt createBy(List<MapExt> items) {
        final MapsExt maps = new MapsExt();
        maps.addAll(items);
        return maps;
    }
}
