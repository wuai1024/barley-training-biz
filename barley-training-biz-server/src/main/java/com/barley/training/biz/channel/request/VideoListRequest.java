package com.barley.training.biz.channel.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoListRequest {

    //可选 直播 id
    private int live_id;
    private int page_index;
    private int page_size;

}
