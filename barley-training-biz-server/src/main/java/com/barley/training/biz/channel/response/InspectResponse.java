package com.barley.training.biz.channel.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
        @JsonProperty("id")
        private int id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("type")
        private int type;

        @JsonProperty("classroom_id")
        private int classroomId;

        @JsonProperty("ip")
        private String ip;

        @JsonProperty("mac")
        private String mac;

        @JsonProperty("comment")
        private String comment;

        @JsonProperty("status")
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

        @JsonProperty("loading")
        private boolean loading;

        @JsonProperty("recorder_status")
        private int recorderStatus;

        @JsonProperty("recorder_class_name")
        private String recorderClassName;

        @JsonProperty("play_url")
        private String playUrl;

        @JsonProperty("m3u8_url")
        private String m3u8Url;

        @JsonProperty("webrtc_url")
        private String webrtcUrl;

        @JsonProperty("picture")
        private String picture;

        @JsonProperty("platform_name")
        private String platformName;

        @JsonProperty("platform_id")
        private int platformId;

        @JsonProperty("streamname")
        private String streamName;

        @JsonProperty("status_stream_audio")
        private Object statusStreamAudio; // 因为此字段在 JSON 中类型不一致（boolean 和 String）

        @JsonProperty("status_stream")
        private Object statusStream; // 同样类型不一致
    }
}
