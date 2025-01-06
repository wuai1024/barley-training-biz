package com.barley.training.biz.channel.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiveRequest {

    private String name;
    //设备ID
    private int recorder_id;
    private int status = 1;
    private int create_id = 2;
    private String start_time;
    private String end_time;
    // 是否录制 0:不录制 1:录制
    private int is_record;
    private String profile;
    private String picture;


}
