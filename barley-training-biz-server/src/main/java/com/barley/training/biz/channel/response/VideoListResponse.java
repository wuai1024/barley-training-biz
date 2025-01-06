package com.barley.training.biz.channel.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VideoListResponse extends ItcBaseResponse {

    private VideoData data;

    @Getter
    @Setter
    public static class VideoData {

        private String status;

        private VideoPageData data;
    }

    @Getter
    @Setter
    public static class VideoPageData {

        @JsonProperty("page_index")
        private int pageIndex;

        @JsonProperty("page_max")
        private int pageMax;

        @JsonProperty("data_sum")
        private int dataSum;

        private List<VideoDetails> data;
    }

    @Getter
    @Setter
    public static class VideoDetails {

        private int status;

        @JsonProperty("app_code")
        private String appCode;

        @JsonProperty("filesize")
        private long fileSize;

        @JsonProperty("push_code")
        private String pushCode;

        private String profile;

        private String path;

        @JsonProperty("study_section_id")
        private int studySectionId;

        @JsonProperty("grade_id")
        private int gradeId;

        @JsonProperty("subject_id")
        private int subjectId;

        private int authority;

        private int id;

        @JsonProperty("cutid")
        private int cutId;

        @JsonProperty("create_time")
        private String createTime;

        private String length;

        private String picture;

        @JsonProperty("video_name")
        private String videoName;

        private int clicks;

        @JsonProperty("user_name")
        private String userName;

        @JsonProperty("u_status")
        private int uStatus;

        @JsonProperty("is_nice")
        private int isNice;

        private int top;

        @JsonProperty("top_time")
        private String topTime;

        private int uid;

        @JsonProperty("avatar_path")
        private String avatarPath;

        private int scores;

        private int type;

        @JsonProperty("study_score")
        private int studyScore;

        private int favs;

        private int comments;

        @JsonProperty("cate_id")
        private int cateId;

        @JsonProperty("status_m3u8")
        private int statusM3u8;

        @JsonProperty("level_source_id")
        private int levelSourceId;

        @JsonProperty("source_url")
        private String sourceUrl;

        @JsonProperty("rtmp_url")
        private String rtmpUrl;

        @JsonProperty("nonlocal")
        private int nonLocal;

        @JsonProperty("app_rtmp_url")
        private String appRtmpUrl;

        @JsonProperty("is_teacher")
        private int isTeacher;

        @JsonProperty("question_count")
        private int questionCount;

        @JsonProperty("type_name")
        private String typeName;

        private String size;

        @JsonProperty("video_url")
        private String videoUrl;

        @JsonProperty("study_user_count")
        private int studyUserCount;

        private String category;

        @JsonProperty("grade_name")
        private String gradeName;

        @JsonProperty("subject_name")
        private String subjectName;

        @JsonProperty("version_name")
        private String versionName;

        @JsonProperty("app_play_url")
        private String appPlayUrl;

        @JsonProperty("cate_name")
        private String cateName;

        @JsonProperty("thumbnail_picture")
        private String thumbnailPicture;

        @JsonProperty("transform_status")
        private boolean transformStatus;

        @JsonProperty("play_url")
        private String playUrl;
    }
}
