package com.barley.training.biz.channel.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiveDetailResponse extends ItcBaseResponse {

    private DataContainer data;

    @Getter
    @Setter
    public static class DataContainer {
        private String status;
        private LiveData data;
    }

    @Getter
    @Setter
    public static class LiveData {
        private int id;
        private String name;

        @JsonProperty("study_section_id")
        private int studySectionId;

        @JsonProperty("grade_id")
        private int gradeId;

        @JsonProperty("subject_id")
        private int subjectId;

        @JsonProperty("class_id")
        private String classId;

        @JsonProperty("recorder_id")
        private int recorderId;

        @JsonProperty("create_id")
        private int createId;

        @JsonProperty("create_time")
        private String createTime;

        @JsonProperty("start_time")
        private String startTime;

        @JsonProperty("end_time")
        private String endTime;

        private String picture;
        private int authority;

        @JsonProperty("is_mobile")
        private int isMobile;

        @JsonProperty("is_record")
        private int isRecord;

        @JsonProperty("record_status")
        private int recordStatus;

        private String profile;
        private String comment;

        private int status;

        @JsonProperty("is_order")
        private int isOrder;

        @JsonProperty("approve_status")
        private int approveStatus;

        @JsonProperty("app_code")
        private String appCode;

        @JsonProperty("push_code")
        private String pushCode;

        @JsonProperty("is_ai")
        private int isAi;

        @JsonProperty("ai_class_id")
        private int aiClassId;

        private String password;

        @JsonProperty("limit_type")
        private int limitType;

        @JsonProperty("limit_id")
        private String limitId;

        @JsonProperty("password_classid")
        private String passwordClassid;

        @JsonProperty("teacher_name")
        private String teacherName;

        @JsonProperty("is_tv713a")
        private int isTv713a;

        @JsonProperty("is_push")
        private int isPush;

        @JsonProperty("level_source_id")
        private int levelSourceId;

        @JsonProperty("standard_id")
        private int standardId;

        @JsonProperty("attend_class_id")
        private String attendClassId;

        @JsonProperty("is_need_login")
        private int isNeedLogin;

        @JsonProperty("device_code")
        private String deviceCode;

        @JsonProperty("user_name")
        private String userName;

        @JsonProperty("avatar_path")
        private String avatarPath;

        @JsonProperty("cl_name")
        private String clName;

        private int type;

        @JsonProperty("stream_addr")
        private String streamAddr;

        @JsonProperty("sign_code")
        private String signCode;

        private String rtmp;

        @JsonProperty("webrtc_url")
        private String webrtcUrl;

        @JsonProperty("_status")
        private int statusCode;

        @JsonProperty("_status_text")
        private String statusText;

        @JsonProperty("examine_status_text")
        private String examineStatusText;

        @JsonProperty("recorder_name")
        private String recorderName;

        private String category;

        @JsonProperty("class_string")
        private String classString;

        @JsonProperty("is_relation")
        private int isRelation;

        @JsonProperty("study_user_count")
        private int studyUserCount;

        @JsonProperty("h5_url")
        private String h5Url;

        @JsonProperty("play_url")
        private String playUrl;

        @JsonProperty("m3u8_url")
        private String m3u8Url;

        @JsonProperty("end_time_secon")
        private int endTimeSecond;

        @JsonProperty("app_picture")
        private String appPicture;

        @JsonProperty("streamname")
        private String streamName;

        @JsonProperty("status_stream_audio")
        private String statusStreamAudio;

        @JsonProperty("status_stream")
        private String statusStream;
    }
}