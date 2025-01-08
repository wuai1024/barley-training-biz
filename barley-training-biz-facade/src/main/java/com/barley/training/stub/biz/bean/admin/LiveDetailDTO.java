package com.barley.training.stub.biz.bean.admin;

import lombok.Data;

@Data
public class LiveDetailDTO {

    private int statusCode;

    private String statusText;

    private String h5Url;

    private String playUrl;

    private String m3u8Url;

    private int isRecord;

    private int recordStatus;

    private int id;

    private String examineStatusText;

    private String createTime;

    private String startTime;

    private String endTime;
}
