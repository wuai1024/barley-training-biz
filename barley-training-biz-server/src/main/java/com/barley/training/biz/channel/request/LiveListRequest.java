package com.barley.training.biz.channel.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiveListRequest {

    //可选 筛选类型（-1：全部；1：未开始； 2：正在直播；3：已过期；4：今日（不含过期的））
    private int live_type;
    // 排序类型（1：升序；2：降序）
    private int order;
    private int page_index;
    private int page_size;

}
