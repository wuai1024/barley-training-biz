package com.barley.api.test;

import com.barley.common.base.JsonUtils;
import com.barley.training.biz.channel.ItcApis;
import com.barley.training.biz.channel.config.ItcConfig;
import com.barley.training.biz.channel.request.*;
import com.barley.training.biz.channel.response.*;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ItcApiTest extends TestCase {

    private ItcApis itcApis;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ItcConfig itcConfig = new ItcConfig();
        itcConfig.setBaseUrl("http://192.168.5.62");
        itcConfig.setCompany("BL");
        itcConfig.setDevice_name("TE-0600R");
        itcConfig.setClient_id("20882088");
        itcConfig.setSecret("5GEClLm01RoUFzUPii3TXJzeBuzNQrxH");
        itcApis = new ItcApis(itcConfig);
        ItcApis.TOKEN_ACCESS.put("itc.accessToken", "5GEClLm01RoUFzUPii3TXJzeBuzNQrxH");
    }

    public void testAccessToken() throws IOException {
        AccessTokenResponse res = itcApis.accessToken();
        System.out.println(JsonUtils.stringify(res));
    }

    public void testDeviceList() throws IOException {
        DeviceListResponse res = itcApis.deviceList();
        System.out.println(JsonUtils.stringify(res));
    }

    public void testLive() throws IOException {
        LiveRequest request = new LiveRequest();
        request.setName("测试直播");
        request.setRecorder_id(1);
        request.setIs_record(1);
        request.setStart_time("2025-01-08 22:10:00");
        request.setEnd_time("2025-01-08 22:15:00");
        LiveResponse res = itcApis.live(request);
        System.out.println(JsonUtils.stringify(res));
    }

    public void testLiveDetail() throws IOException {
        LiveDetailResponse res = itcApis.liveDetail("9");
        System.out.println(JsonUtils.stringify(res));
    }

    public void testLiveList() throws IOException {
        LiveListRequest request = new LiveListRequest();
        request.setLive_type(1);
        request.setOrder(1);
        request.setPage_index(1);
        request.setPage_size(10);
        LiveListResponse res = itcApis.liveList(request);
        System.out.println(JsonUtils.stringify(res));
    }

    public void testVideoList() throws IOException {
        VideoListRequest request = new VideoListRequest();
        request.setLive_id(9);
        request.setPage_index(1);
        request.setPage_size(10);
        VideoListResponse res = itcApis.videoList(request);
        System.out.println(JsonUtils.stringify(res));
    }

    public void testInspect() throws IOException {
        InspectResponse res = itcApis.inspect();
        System.out.println(JsonUtils.stringify(res));
    }


    public void testParse() {
        String responseStr = """
                {
                  "status": "success",
                  "code": 200,
                  "msg": "操作成功！",
                  "data": [
                    {
                      "id": 7,
                      "name": "摄像头六",
                      "type": 4,
                      "classroom_id": 17,
                      "ip": "192.168.1.82",
                      "mac": "",
                      "comment": "",
                      "status": 1,
                      "class_id": 0,
                      "dev_id": 0,
                      "stream_addr": "rtsp://192.168.1.82:554",
                      "sign_code": "",
                      "app_code": "00000000000000000000000000000000",
                      "is_distribution": 1,
                      "device_code": "",
                      "ip_string": [],
                      "class_name": "学校>摄像头六",
                      "loading": true,
                      "recorder_status": -1,
                      "recorder_class_name": "摄像头六(学校>摄像头六)",
                      "play_url": "http://192.168.5.62/live/7_stream.flv",
                      "m3u8_url": "http://192.168.5.62/public/hls_live/7_stream/index.m3u8",
                      "picture": "/static/default/video_preview.png",
                      "platform_name": "itc学校",
                      "platform_id": 1,
                      "streamname": "7_stream",
                      "status_stream_audio": false,
                      "status_stream": false
                    },
                    {
                      "id": 6,
                      "name": "摄像头五",
                      "type": 4,
                      "classroom_id": 16,
                      "ip": "192.168.5.34",
                      "mac": "",
                      "comment": "",
                      "status": 1,
                      "class_id": 0,
                      "dev_id": 0,
                      "stream_addr": "rtsp://192.168.5.34:554",
                      "sign_code": "",
                      "app_code": "00000000000000000000000000000000",
                      "is_distribution": 1,
                      "device_code": "",
                      "ip_string": [],
                      "class_name": "学校>摄像头五",
                      "loading": true,
                      "recorder_status": -1,
                      "recorder_class_name": "摄像头五(学校>摄像头五)",
                      "play_url": "http://192.168.5.62/live/6_stream.flv",
                      "m3u8_url": "http://192.168.5.62/public/hls_live/6_stream/index.m3u8",
                      "picture": "/static/default/video_preview.png",
                      "platform_name": "itc学校",
                      "platform_id": 1,
                      "streamname": "6_stream",
                      "status_stream_audio": "1",
                      "status_stream": "1"
                    },
                    {
                      "id": 5,
                      "name": "摄像头四",
                      "type": 4,
                      "classroom_id": 15,
                      "ip": "192.168.5.58",
                      "mac": "",
                      "comment": "",
                      "status": 1,
                      "class_id": 0,
                      "dev_id": 0,
                      "stream_addr": "rtsp://192.168.5.58:554",
                      "sign_code": "",
                      "app_code": "00000000000000000000000000000000",
                      "is_distribution": 1,
                      "device_code": "",
                      "ip_string": [],
                      "class_name": "学校>摄像头四",
                      "loading": true,
                      "recorder_status": -1,
                      "recorder_class_name": "摄像头四(学校>摄像头四)",
                      "play_url": "http://192.168.5.62/live/5_stream.flv",
                      "m3u8_url": "http://192.168.5.62/public/hls_live/5_stream/index.m3u8",
                      "picture": "/static/default/video_preview.png",
                      "platform_name": "itc学校",
                      "platform_id": 1,
                      "streamname": "5_stream",
                      "status_stream_audio": "0",
                      "status_stream": "1"
                    },
                    {
                      "id": 4,
                      "name": "摄像头三",
                      "type": 4,
                      "classroom_id": 14,
                      "ip": "192.168.5.59",
                      "mac": "",
                      "comment": "",
                      "status": 1,
                      "class_id": 0,
                      "dev_id": 0,
                      "stream_addr": "rtsp://192.168.5.59:554",
                      "sign_code": "",
                      "app_code": "00000000000000000000000000000000",
                      "is_distribution": 1,
                      "device_code": "",
                      "ip_string": [],
                      "class_name": "学校>摄像头三",
                      "loading": true,
                      "recorder_status": -1,
                      "recorder_class_name": "摄像头三(学校>摄像头三)",
                      "play_url": "http://192.168.5.62/live/4_stream.flv",
                      "m3u8_url": "http://192.168.5.62/public/hls_live/4_stream/index.m3u8",
                      "picture": "/static/default/video_preview.png",
                      "platform_name": "itc学校",
                      "platform_id": 1,
                      "streamname": "4_stream",
                      "status_stream_audio": "0",
                      "status_stream": "1"
                    },
                    {
                      "id": 3,
                      "name": "摄像头二",
                      "type": 4,
                      "classroom_id": 13,
                      "ip": "192.168.5.61",
                      "mac": "",
                      "comment": "",
                      "status": 1,
                      "class_id": 0,
                      "dev_id": 0,
                      "stream_addr": "rtsp://192.168.5.61:554",
                      "sign_code": "",
                      "app_code": "00000000000000000000000000000000",
                      "is_distribution": 1,
                      "device_code": "",
                      "ip_string": [],
                      "class_name": "学校>摄像头二",
                      "loading": true,
                      "recorder_status": -1,
                      "recorder_class_name": "摄像头二(学校>摄像头二)",
                      "play_url": "http://192.168.5.62/live/3_stream.flv",
                      "m3u8_url": "http://192.168.5.62/public/hls_live/3_stream/index.m3u8",
                      "picture": "/static/default/video_preview.png",
                      "platform_name": "itc学校",
                      "platform_id": 1,
                      "streamname": "3_stream",
                      "status_stream_audio": "1",
                      "status_stream": "1"
                    },
                    {
                      "id": 2,
                      "name": "摄像头一",
                      "type": 4,
                      "classroom_id": 12,
                      "ip": "192.168.5.60",
                      "mac": "",
                      "comment": "",
                      "status": 1,
                      "class_id": 0,
                      "dev_id": 0,
                      "stream_addr": "rtsp://192.168.5.60:554",
                      "sign_code": "",
                      "app_code": "00000000000000000000000000000000",
                      "is_distribution": 1,
                      "device_code": "",
                      "ip_string": [],
                      "class_name": "学校>摄像头一",
                      "loading": true,
                      "recorder_status": -1,
                      "recorder_class_name": "摄像头一(学校>摄像头一)",
                      "play_url": "http://192.168.5.62/live/2_stream.flv",
                      "m3u8_url": "http://192.168.5.62/public/hls_live/2_stream/index.m3u8",
                      "picture": "/static/default/video_preview.png",
                      "platform_name": "itc学校",
                      "platform_id": 1,
                      "streamname": "2_stream",
                      "status_stream_audio": "1",
                      "status_stream": "1"
                    }
                  ]
                }
                """;

        InspectResponse resp = JsonUtils.parse(responseStr, InspectResponse.class);
        Map<String, String> inspectMap = Optional.ofNullable(resp.getData()).orElseGet(List::of).stream()
                .collect(Collectors.toMap(InspectResponse.DeviceData::getIp, InspectResponse.DeviceData::getM3u8Url, (p, n) -> p));

        System.out.printf(resp.toString());
    }


}
