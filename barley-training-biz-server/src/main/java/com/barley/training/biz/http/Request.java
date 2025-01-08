package com.barley.training.biz.http;

import java.io.IOException;
import java.util.Map;

public interface Request {

    /**
     * 添加请求头部.
     *
     * @param name  Key 参数.
     * @param value Value 参数.
     * @return 请求实体.
     */
    Request header(String name, String value);

    /**
     * 通过Map 创建头部.
     *
     * @param params 参数.
     * @return 请求实体.
     */
    default Request headers(Map<String, String> params) {
        params.forEach(this::header);
        return this;
    }

    /**
     * 通过Map 创建参数.
     *
     * @param name   Key 参数.
     * @param values Value 参数.
     * @return 请求实体.
     */
    Request queryParam(String name, String... values);

    /**
     * 通过Map 创建参数.
     *
     * @param params 参数.
     * @return 请求实体.
     */
    default Request queryParams(Map<String, String> params) {
        params.forEach(this::queryParam);
        return this;
    }

    /**
     * 通过参数创建表单.
     *
     * @param name   Key 参数.
     * @param values Value 参数.
     * @return 请求实体.
     */
    Request formParam(String name, String... values);

    /**
     * 通过Map 创建表单.
     *
     * @param params 参数.
     * @return 请求实体.
     */
    default Request formParams(Map<String, String> params) {
        params.forEach(this::formParam);
        return this;
    }

    /**
     * 发送请求.
     *
     * @return 响应实体.
     */
    Response get() throws IOException;

    /**
     * 发送请求.
     *
     * @return 响应实体.
     */
    Response postForm() throws IOException;

    /**
     * 发送请求.
     *
     * @return 响应实体.
     */
    Response post(String body) throws IOException;

    /**
     * 发送请求.
     *
     * @param json 请求参数.
     * @return 响应实体.
     */
    Response postJson(String json) throws IOException;

    /**
     * 发送请求.
     *
     * @param xml 请求参数.
     * @return 响应实体.
     */
    Response postXml(String xml) throws IOException;

    /**
     * 发送请求.
     *
     * @return 响应实体.
     */
    Response putForm() throws IOException;

    /**
     * 发送请求.
     *
     * @param json 请求参数.
     * @return 响应实体.
     */
    Response putJson(String json) throws IOException;

    /**
     * 发送请求.
     *
     * @return 响应实体.
     */
    Response delete() throws IOException;

    Response deleteJson(String json) throws IOException;

}
