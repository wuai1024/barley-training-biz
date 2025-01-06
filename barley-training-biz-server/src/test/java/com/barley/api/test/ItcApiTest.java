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
        itcConfig.setSecret("nGk5R2wrnZqQ02bed29rjzax1QWRIu1O");
        itcApis = new ItcApis(itcConfig);
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
        request.setName("test");
        request.setRecorder_id(1);
        request.setIs_record(1);
        request.setStart_time("2025-01-06 20:15:00");
        request.setEnd_time("2025-01-06 20:17:00");
        LiveResponse res = itcApis.live(request);
        System.out.println(JsonUtils.stringify(res));
    }

    public void testLiveDetail() throws IOException {
        LiveDetailResponse res = itcApis.liveDetail("3");
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
        request.setLive_id(3);
        request.setPage_index(1);
        request.setPage_size(10);
        VideoListResponse res = itcApis.videoList(request);
        System.out.println(JsonUtils.stringify(res));
    }


    public void testParse(){
        String responseStr ="{\"company\":\"BL\",\"device_name\":\"TE-0600R\",\"result\":200,\"return_message\":\"操作成功！\",\"data\":{\"status\":\"success\",\"data\":[{\"id\":1,\"name\":\"ITC_1\",\"type\":10,\"classroom_id\":0,\"ip\":\"192.168.5.63\",\"mac\":\"TS-0650C\",\"comment\":\"\",\"status\":1,\"class_id\":0,\"dev_id\":0,\"stream_addr\":\"\",\"sign_code\":\"1_yqza9ow40d\",\"app_code\":\"00000000000000000000000000000000\",\"is_distribution\":0,\"device_code\":\"\",\"ip_string\":[],\"class_name\":\"\",\"loading\":true,\"recorder_status\":-1,\"recorder_class_name\":\"ITC_1()\",\"play_url\":\"http:\\/\\/192.168.5.62\\/live\\/1_yqza9ow40d.flv\",\"picture\":\"\\/static\\/default\\/video_preview.png\",\"platform_name\":\"itc学校\",\"platform_id\":1,\"streamname\":\"1_yqza9ow40d\",\"status_stream_audio\":\"1\",\"status_stream\":\"1\",\"org_class_name\":\"\"}]}}";
        DeviceListResponse resp = JsonUtils.parse(responseStr, DeviceListResponse.class);
        System.out.printf(resp.toString());
    }


}
