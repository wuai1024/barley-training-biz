package com.barley.training.biz.channel;


import com.barley.common.base.JsonUtils;
import com.barley.training.biz.channel.config.ItcConfig;
import com.barley.training.biz.channel.request.*;
import com.barley.training.biz.channel.response.*;
import com.barley.training.biz.http.ApisHttp;
import com.barley.training.biz.http.Response;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ItcApis {

    public static final Cache<String, String> TOKEN_ACCESS = Caffeine.newBuilder()
            .expireAfterWrite(7000, TimeUnit.SECONDS) // Set expiration time
            .build();

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
                .postJson(JsonUtils.stringify(accessTokenRequest));
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
        String cacheKey = "itc.accessToken";
        String cachedToken = TOKEN_ACCESS.getIfPresent(cacheKey);
        if (cachedToken != null) {
            return cachedToken;
        }

        AccessTokenResponse accessTokenResponse = accessToken();
        Optional.ofNullable(accessTokenResponse).orElseThrow(() -> new RuntimeException("获取accessToken失败"));
        TOKEN_ACCESS.put(cacheKey, accessTokenResponse.getAccessToken());
        return accessTokenResponse.getAccessToken();
    }

    /**
     * 设备列表
     *
     * @return
     * @throws IOException
     */
    public DeviceListResponse deviceList() throws IOException {
        ItcRequest<Map<String, String>> deviceRequest = new ItcRequest<>();
        deviceRequest.setCompany(config.getCompany());
        deviceRequest.setDevice_name(config.getDevice_name());
        deviceRequest.setData(Map.of());
        String path = "/appapi/recorder/recorder_list_post";
        Response response = apisHttp
                .request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .postJson(JsonUtils.stringify(deviceRequest));

        int httpStatusCode = response.statusCode();
        String responseStr = response.bodyString();
        DeviceListResponse deviceListResponse = JsonUtils.parse(responseStr, DeviceListResponse.class);
        deviceListResponse.setResponseStr(responseStr);
        deviceListResponse.setHttpStatusCode(httpStatusCode);
        return deviceListResponse;
    }

    /**
     * 直播预约
     *
     * @param liveRequest
     * @return
     * @throws IOException
     */
    public LiveResponse live(LiveRequest liveRequest) throws IOException {
        ItcRequest<LiveRequest> liveReq = new ItcRequest<>();
        liveReq.setCompany(config.getCompany());
        liveReq.setDevice_name(config.getDevice_name());
        liveReq.setMethod("add");
        liveReq.setData(liveRequest);
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
     * @
     */
    public LiveDetailResponse liveDetail(String liveId) throws IOException {
        String path = "/appapi/live/live_post";
        ItcRequest<Map<String, String>> liveDetailRequest = new ItcRequest<>();
        liveDetailRequest.setCompany(config.getCompany());
        liveDetailRequest.setDevice_name(config.getDevice_name());
        liveDetailRequest.setMethod("detail");
        liveDetailRequest.setData(Map.of("liveid", liveId));

        Response response = apisHttp.request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .postJson(JsonUtils.stringify(liveDetailRequest));
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
        String path = "/appapi/live/live_list_post";
        ItcRequest<LiveListRequest> liveDetailRequest = new ItcRequest<>();
        liveDetailRequest.setCompany(config.getCompany());
        liveDetailRequest.setDevice_name(config.getDevice_name());
        liveDetailRequest.setData(liveListRequest);

        Response response = apisHttp.request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .postJson(JsonUtils.stringify(liveDetailRequest));
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
        String path = "/appapi/video/video_list_post";
        ItcRequest<VideoListRequest> liveDetailRequest = new ItcRequest<>();
        liveDetailRequest.setCompany(config.getCompany());
        liveDetailRequest.setDevice_name(config.getDevice_name());
        liveDetailRequest.setLive_id(videoListRequest.getLive_id());
        liveDetailRequest.setData(videoListRequest);

        Response response = apisHttp.request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .postJson(JsonUtils.stringify(liveDetailRequest));
        int httpStatusCode = response.statusCode();
        String responseStr = response.bodyString();
        VideoListResponse videoListResponse = JsonUtils.parse(responseStr, VideoListResponse.class);
        videoListResponse.setResponseStr(responseStr);
        videoListResponse.setHttpStatusCode(httpStatusCode);
        return videoListResponse;
    }

    /**
     * 巡检
     *
     * @return
     * @throws IOException
     */
    public InspectResponse inspect() throws IOException {
        String path = "/appapi/recorder/recorder_list_post";
        InspectRequest inspectRequest = new InspectRequest();
        Response response = apisHttp.request(config.getBaseUrl(), path)
                .header("Authorization", "Bearer " + this.getAccessToken())
                .postJson(JsonUtils.stringify(inspectRequest));
        int httpStatusCode = response.statusCode();
        String responseStr = response.bodyString();
        InspectResponse inspectResponse = JsonUtils.parse(responseStr, InspectResponse.class);
        inspectResponse.setResponseStr(responseStr);
        inspectResponse.setHttpStatusCode(httpStatusCode);
        return inspectResponse;
    }

}
