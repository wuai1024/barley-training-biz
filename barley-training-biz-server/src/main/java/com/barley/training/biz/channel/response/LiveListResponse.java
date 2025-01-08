package com.barley.training.biz.channel.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LiveListResponse extends ItcBaseResponse {

    private DataWrapper data;

    @Getter
    @Setter
    public static class DataWrapper {
        private String status;
        private InnerData data;
    }

    @Getter
    @Setter
    public static class InnerData {
        private int pageIndex;
        private int pageMax;
        private int dataSum;
        private List<LiveInfo> data;
    }

    @Getter
    @Setter
    public static class LiveInfo {
        private int id;
        private String name;
        private int studySectionId;
        private int gradeId;
        private int subjectId;
        private String classId;
        private int recorderId;
        private int createId;
        private String createTime;
        private String startTime;
        private String endTime;
        private String picture;
        private int authority;
        private int isMobile;
        private int isRecord;
        private int recordStatus;
        private String profile;
        private String comment;
        private int status;
        private int isOrder;
        private int approveStatus;
        private String appCode;
        private String pushCode;
        private int isAi;
        private int aiClassId;
        private String password;
        private int limitType;
        private String limitId;
        private String passwordClassid;
        private String teacherName;
        private int isTv713a;
        private int isPush;
        private int levelSourceId;
        private int standardId;
        private Object attendClassId; // 使用Object，因为JSON中为null
        private int isNeedLogin;
        private String deviceCode;
        private int syllabusId;
        private String recorderName;
        private String ip;
        private String signCode;
        private String teachername;
        private String avatarPath;
        private String clName;
        private int type;
        private String streamAddr;
        private Object subjectname; // 使用Object，因为JSON中为null
        private Object studyname; // 使用Object，因为JSON中为null
        private Object gradename; // 使用Object，因为JSON中为null
        private String sourceUrl;
        private String rtmp;
        private String playUrl;
        private String webrtcUrl;
        private String m3u8Url;
        private String streamname;
        private String statusStreamAudio;
        private String statusStream;
        private int _status;
        private String _statusText;
        private String examineStatusText;
        private String duration;
        private String liveUrl;
        private String timeString;
        private String category;
        private String className;
        private int endTimeSecon;
        private String serviceTime;
    }
}
