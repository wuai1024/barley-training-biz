package com.barley.training.biz.channel.config;

import lombok.Data;

@Data
public class ItcConfig {

    /**
     * 基础请求地址
     */
    private String baseUrl;
    private String company;
    private String device_name;
    private String client_id;
    private String secret;

}
