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
        private LiveData data;
    }

    @Getter
    @Setter
    public static class LiveData {
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
        private String passwordClassId;
        private String teacherName;
        private int isTv713a;
        private int isPush;
        private int levelSourceId;
        private int standardId;
        private String attendClassId;
        private int isNeedLogin;
        private String deviceCode;
        private String recorderName;
        private String ip;
        private String signCode;
        private String teachername;
        private String avatarPath;
        private String clName;
        private Integer type;
        private String streamAddr;
        private String subjectname;
        private String studyname;
        private String gradename;
        private String sourceUrl;
        private String rtmp;
        private String playUrl;
        private String webrtcUrl;
        private int streamname;
        private boolean statusStreamAudio;
        private boolean statusStream;
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
