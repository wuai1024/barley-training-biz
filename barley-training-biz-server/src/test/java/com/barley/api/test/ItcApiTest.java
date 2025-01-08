package com.barley.api.test;

import com.barley.common.base.JsonUtils;
import com.barley.training.biz.channel.ItcApis;
import com.barley.training.biz.channel.config.ItcConfig;
import com.barley.training.biz.channel.request.*;
import com.barley.training.biz.channel.response.*;
import junit.framework.TestCase;

import java.io.IOException;

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
        String responseStr = "{\"company\":\"BL\",\"device_name\":\"TE-0600R\",\"result\":200,\"return_message\":\"操作成功！\",\"data\":{\"status\":\"success\",\"data\":{\"page_index\":1,\"page_max\":1,\"data_sum\":1,\"data\":[{\"id\":5,\"name\":\"test\",\"study_section_id\":0,\"grade_id\":0,\"subject_id\":0,\"class_id\":\"\",\"recorder_id\":1,\"create_id\":2,\"create_time\":\"2025-01-08 17:32:28\",\"start_time\":\"2025-01-08 20:15:00\",\"end_time\":\"2025-01-08 20:17:00\",\"picture\":\"\\/static\\/default\\/video_preview.png\",\"authority\":1,\"is_mobile\":0,\"is_record\":1,\"record_status\":0,\"profile\":\"\",\"comment\":\"\",\"status\":1,\"is_order\":1,\"approve_status\":1,\"app_code\":\"00000000000000000000000000000000\",\"push_code\":\"00000000000000000000000000000000\",\"is_ai\":0,\"ai_class_id\":0,\"password\":\"\",\"limit_type\":0,\"limit_id\":\"\",\"password_classid\":\"\",\"teacher_name\":\"\",\"is_tv713a\":0,\"is_push\":0,\"level_source_id\":0,\"standard_id\":0,\"attend_class_id\":null,\"is_need_login\":0,\"device_code\":\"\",\"syllabus_id\":0,\"recorder_name\":\"ITC_1\",\"ip\":\"192.168.5.63\",\"sign_code\":\"1_yqza9ow40d\",\"teachername\":\"超级管理员\",\"avatar_path\":\"\\/static\\/default\\/user_preview-1.png\",\"cl_name\":\"\",\"type\":10,\"stream_addr\":\"\",\"subjectname\":null,\"studyname\":null,\"gradename\":null,\"source_url\":\"\",\"rtmp\":\"rtmp:\\/\\/192.168.5.62:1114\\/live\\/1_yqza9ow40d\",\"play_url\":\"http:\\/\\/192.168.5.62\\/live\\/1_yqza9ow40d.flv\",\"webrtc_url\":\"webrtc:\\/\\/192.168.5.62\\/live\\/1_yqza9ow40d\",\"m3u8_url\":\"http:\\/\\/192.168.5.62\\/public\\/hls_live\\/1_yqza9ow40d\\/index.m3u8\",\"streamname\":\"1_yqza9ow40d\",\"status_stream_audio\":\"1\",\"status_stream\":\"1\",\"_status\":1,\"_status_text\":\"未开始\",\"examine_status_text\":\"已通过\",\"duration\":\"2025-01-08 20:15:00至20:17:00\",\"live_url\":\"\\/index\\/live\\/live_room\\/id\\/5\",\"time_string\":\"2025-01-08 20:15-20:17\",\"category\":\"itc学校\",\"class_name\":\"\",\"end_time_secon\":7330,\"service_time\":\"2025-01-08 18:14:50\"}]}}}";
        LiveListResponse resp = JsonUtils.parse(responseStr, LiveListResponse.class);
        System.out.printf(resp.toString());
    }


}
