package com.barley.training.stub.biz.bean.client;

import lombok.Getter;
import lombok.Setter;

/**
 * 巡查
 */
@Getter
@Setter
public class InspectDTO {

    private String classroomName;
    private String deviceName;
    private String type;
    private String m3u8Url; // 视频URL
    private String webrtcUrl; // 视频URL
    private String playUrl; // 视频URL
}
