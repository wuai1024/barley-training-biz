package com.barley.training.biz.channel;


import com.barley.common.base.JsonUtils;
import com.barley.training.biz.channel.config.ItcConfig;
import com.barley.training.biz.channel.request.*;
import com.barley.training.biz.channel.response.*;
import com.barley.training.biz.http.ApisHttp;
import com.barley.training.biz.http.Response;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class ItcApis {

    private final ItcConfig config;
    private final ApisHttp apisHttp;

    public ItcApis(ItcConfig config) {
        this.config = config;
        this.apisHttp = ApisHttp.Builder.build();
    }

    /**
     * @return
     * @throws IOException
     */
    public AccessTokenResponse accessToken() throws IOException {
        ItcRequest<Map<String, String>> accessTokenRequest = new ItcRequest<>();
        accessTokenRequest.setCompany(config.getCompany());
        accessTokenRequest.setDevice_name(config.getDevice_name());
        accessTokenRequest.setData(Map.of("client_id", config.getClient_id(), "secret", config.getSecret()));

        String path = "/accessToken";
        Response response = apisHttp
                .request(config.getBaseUrl(), path)
                .getJson(JsonUtils.stringify(accessTokenRequest));
        int httpStatusCode = response.statusCode();
        String responseStr = response.bodyString();
        AccessTokenResponse accessTokenResponse = JsonUtils.parse(responseStr, AccessTokenResponse.class);
        accessTokenResponse.setResponseStr(responseStr);
        accessTokenResponse.setHttpStatusCode(httpStatusCode);
        return accessTokenResponse;
    }

    /**
     * @return
     * @throws IOException
     */
    private String getAccessToken() throws IOException {
        return "mfRSpHMnM37N17e617FZRblQeaBdbEjM";

//        AccessTokenResponse accessTokenResponse = accessToken();
//        Optional.ofNullable(accessTokenResponse).orElseThrow(() -> new RuntimeException("获取accessToken失败"));
//        return accessTokenResponse.getAccessToken();
    }

    /**
     * @return
     * @throws IOException
     */
    public DeviceListResponse deviceList() throws IOException {
        ItcRequest<Map<String, String>> liveRequest = new ItcRequest<>();
        liveRequest.setCompany(config.getCompany());
        liveRequest.setDevice_name(config.getDevice_name());
        liveRequest.setData(Map.of());
        String path = "/appapi/recorder/recorder_list";
        Response response = apisHttp
                .request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .getJson(JsonUtils.stringify(liveRequest));

        int httpStatusCode = response.statusCode();
        String responseStr = response.bodyString();
        DeviceListResponse deviceListResponse = JsonUtils.parse(responseStr, DeviceListResponse.class);
        deviceListResponse.setResponseStr(responseStr);
        deviceListResponse.setHttpStatusCode(httpStatusCode);
        return deviceListResponse;
    }

    /**
     * @param liveRequest
     * @return
     * @throws IOException
     */
    public LiveResponse live(LiveRequest liveRequest) throws IOException {
        String path = "/appapi/live/live";
        Response response = apisHttp
                .request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .postJson(JsonUtils.stringify(liveRequest));
        int httpStatusCode = response.statusCode();
        String responseStr = response.bodyString();
        LiveResponse liveResponse = JsonUtils.parse(responseStr, LiveResponse.class);
        liveResponse.setResponseStr(responseStr);
        liveResponse.setHttpStatusCode(httpStatusCode);
        return liveResponse;
    }

    /**
     * @param liveId
     * @return
     * @throws IOException
     */
    public LiveDetailResponse liveDetail(String liveId) throws IOException {
        String path = "/appapi/live/live";
        ItcRequest<Map<String, String>> liveDetailRequest = new ItcRequest<>();
        liveDetailRequest.setCompany(config.getCompany());
        liveDetailRequest.setDevice_name(config.getDevice_name());
        liveDetailRequest.setData(Map.of("liveid", liveId));

        Response response = apisHttp.request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .getJson(JsonUtils.stringify(liveDetailRequest));
        int httpStatusCode = response.statusCode();
        String responseStr = response.bodyString();
        LiveDetailResponse liveDetailResponse = JsonUtils.parse(responseStr, LiveDetailResponse.class);
        liveDetailResponse.setResponseStr(responseStr);
        liveDetailResponse.setHttpStatusCode(httpStatusCode);
        return liveDetailResponse;
    }

    /**
     * @param liveId
     * @return
     * @throws IOException
     */
    public Boolean liveDelete(Integer liveId) throws IOException {
        String path = "/appapi/live/live";
        ItcRequest<Map<String, Object>> liveDetailRequest = new ItcRequest<>();
        liveDetailRequest.setCompany(config.getCompany());
        liveDetailRequest.setDevice_name(config.getDevice_name());
        liveDetailRequest.setData(Map.of("liveid", liveId, "type", "2"));

        Response response = apisHttp.request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .deleteJson(JsonUtils.stringify(liveDetailRequest));
        int httpStatusCode = response.statusCode();
        String responseStr = response.bodyString();
        LiveDeleteResponse liveDeleteResponse = JsonUtils.parse(responseStr, LiveDeleteResponse.class);
        liveDeleteResponse.setResponseStr(responseStr);
        liveDeleteResponse.setHttpStatusCode(httpStatusCode);
        if (Objects.equals(liveDeleteResponse.getResult(), "200")) {
            return true;
        }
        return false;
    }

    /**
     * 直播列表
     *
     * @param liveListRequest
     * @return
     * @throws IOException
     */
    public LiveListResponse liveList(LiveListRequest liveListRequest) throws IOException {
        String path = "/appapi/live/live_list";
        ItcRequest<LiveListRequest> liveDetailRequest = new ItcRequest<>();
        liveDetailRequest.setCompany(config.getCompany());
        liveDetailRequest.setDevice_name(config.getDevice_name());
        liveDetailRequest.setData(liveListRequest);

        Response response = apisHttp.request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .getJson(JsonUtils.stringify(liveDetailRequest));
        int httpStatusCode = response.statusCode();
        String responseStr = response.bodyString();
        LiveListResponse liveListResponse = JsonUtils.parse(responseStr, LiveListResponse.class);
        liveListResponse.setResponseStr(responseStr);
        liveListResponse.setHttpStatusCode(httpStatusCode);
        return liveListResponse;
    }

    /**
     * 视频列表
     *
     * @param videoListRequest
     * @return
     * @throws IOException
     */
    public VideoListResponse videoList(VideoListRequest videoListRequest) throws IOException {
        String path = "/appapi/video/video_list";
        ItcRequest<VideoListRequest> liveDetailRequest = new ItcRequest<>();
        liveDetailRequest.setCompany(config.getCompany());
        liveDetailRequest.setDevice_name(config.getDevice_name());
        liveDetailRequest.setData(videoListRequest);

        Response response = apisHttp.request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .getJson(JsonUtils.stringify(liveDetailRequest));
        int httpStatusCode = response.statusCode();
        String responseStr = response.bodyString();
        VideoListResponse videoListResponse = JsonUtils.parse(responseStr, VideoListResponse.class);
        videoListResponse.setResponseStr(responseStr);
        videoListResponse.setHttpStatusCode(httpStatusCode);
        return videoListResponse;
    }

}
