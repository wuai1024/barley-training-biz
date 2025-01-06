package com.barley.training.biz.channel.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeviceListResponse extends ItcBaseResponse {

    private DataContainer data;

    @Getter
    @Setter
    public static class DataContainer {
        private String status;
        private List<DeviceData> data;
    }

    @Getter
    @Setter
    public static class DeviceData {
        private int id;
        private String name;
        private int type;
        @JsonProperty("classroom_id")
        private int classroomId;
        private String ip;
        private String mac;
        private String comment;
        private int status;
        @JsonProperty("class_id")
        private int classId;
        @JsonProperty("dev_id")
        private int devId;
        @JsonProperty("stream_addr")
        private String streamAddr;
        @JsonProperty("sign_code")
        private String signCode;
        @JsonProperty("app_code")
        private String appCode;
        @JsonProperty("is_distribution")
        private int isDistribution;
        @JsonProperty("device_code")
        private String deviceCode;
        @JsonProperty("ip_string")
        private List<String> ipString;
        @JsonProperty("class_name")
        private String className;
        private boolean loading;
        @JsonProperty("recorder_status")
        private int recorderStatus;
        @JsonProperty("recorder_class_name")
        private String recorderClassName;
        @JsonProperty("play_url")
        private String playUrl;
        private String picture;
        @JsonProperty("platform_name")
        private String platformName;
        @JsonProperty("platform_id")
        private int platformId;
        @JsonProperty("streamname")
        private String streamName;
        @JsonProperty("status_stream_audio")
        private String statusStreamAudio;
        @JsonProperty("status_stream")
        private String statusStream;
        @JsonProperty("org_class_name")
        private String orgClassName;
    }

}
