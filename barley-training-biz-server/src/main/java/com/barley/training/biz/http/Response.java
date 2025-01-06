package com.barley.training.biz.http;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

public interface Response {
    /**
     * 响应状态码.
     *
     * @return 状态.
     */
    int statusCode();

    /**
     * 获取响应内容.
     *
     * @return 内容.
     */
    byte[] body();

    /**
     * 获取响应流.
     *
     * @return 返回响应流.
     */
    InputStream bodyStream();

    /**
     * 获取响应头部.
     *
     * @return 头部信息.
     */
    Map<String, String> headers();

    /**
     * 获取响应内容.默认设置Charset(UTF-8)
     *
     * @return 字符串内容.
     */
    String bodyString();

    /**
     * 获取响应内容.手动设置Charset
     *
     * @return 字符串内容.
     */
    String bodyString(Charset charset);

}
