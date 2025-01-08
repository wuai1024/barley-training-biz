package com.barley.training.biz.channel.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class InspectResponse extends ItcBaseResponse {

    private String status;
    private int code;
    private String msg;
    private List<DeviceData> data;

    @Data
    public static class DeviceData {
        private int id;
        private String name;
        private int type;
        private int classroomId;
        private String ip;
        private String mac;
        private String comment;
        private int status;
        private int classId;
        private int devId;
        private String streamAddr;
        private String signCode;
        private String appCode;
        private int isDistribution;
        private String deviceCode;
        private List<String> ipString;
        private String className;
        private boolean loading;
        private int recorderStatus;
        private String recorderClassName;
        private String playUrl;
        private String m3u8Url;
        private String picture;
        private String platformName;
        private int platformId;
        private String streamname;
        private String statusStreamAudio;
        private String statusStream;
    }
}
