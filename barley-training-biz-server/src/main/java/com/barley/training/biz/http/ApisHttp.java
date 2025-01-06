package com.barley.training.biz.http;

public interface ApisHttp {

    /**
     * 创建Request 请求.
     *
     * @param url   请求地址.
     * @param paths 请求路径.
     * @return Request 实体.
     */
    Request request(String url, String... paths);

    class Builder {

        public static ApisHttp build() {
            return new ApisHttpOkImpl();
        }
    }

}
