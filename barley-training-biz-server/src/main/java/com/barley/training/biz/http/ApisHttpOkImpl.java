package com.barley.training.biz.http;

import com.barley.training.biz.http.utils.TrueHostnameVerifier;
import com.moczul.ok2curl.CurlInterceptor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.barley.training.biz.constant.OKHttpConstants.*;

@Slf4j
public class ApisHttpOkImpl implements ApisHttp {

    private final OkHttpClient okHttpClient;

    public ApisHttpOkImpl() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(DISPATCHER_MAX_REQUESTS);
        dispatcher.setMaxRequestsPerHost(DISPATCHER_MAX_REQUESTS_PER_HOST);
        ConnectionPool connectionPool = new ConnectionPool(
                CONNECTION_POOL_MAX_IDLE_COUNT,
                CONNECTION_POOL_MAX_IDLE_MINUTES,
                TimeUnit.MINUTES);
        final OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .dispatcher(dispatcher)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .connectionPool(connectionPool)
                .hostnameVerifier(new TrueHostnameVerifier())
                .addNetworkInterceptor(new CurlInterceptor(log::info));
        okHttpClient = builder.build();
    }

    @Override
    public Request request(String url, String... paths) {
        return new MyRequest(url, paths);
    }

    private class MyRequest implements Request {
        private final HttpUrl.Builder httpUrlBuilder;
        private final FormBody.Builder formBodyBuilder;
        private final Map<String, String> headerMap = new HashMap<>();

        public MyRequest(String url, String... paths) {
            httpUrlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
            formBodyBuilder = new FormBody.Builder();
            if (Objects.nonNull(paths) && paths.length > 0) {
                for (String path : paths) {
                    if (path.startsWith("/")) {
                        httpUrlBuilder.addPathSegments(path.substring(1));
                    } else {
                        httpUrlBuilder.addPathSegments(path);
                    }
                }
            }
        }

        @Override
        public Request header(String name, String value) {
            headerMap.put(name, value);
            return this;
        }

        @Override
        public Request queryParam(String name, String... values) {
            for (String value : values) {
                httpUrlBuilder.addQueryParameter(name, value);
            }
            return this;
        }

        @Override
        public Request formParam(String name, String... values) {
            for (String value : values) {
                formBodyBuilder.add(name, value);
            }
            return this;
        }

        @Override
        public Response get() throws IOException {
            final okhttp3.Request.Builder builder = this.create();
            final okhttp3.Request request = builder.get().build();
            return new MyResponse(newCall(request));
        }

        @Override
        public Response getJson(String json) throws IOException {
            final okhttp3.Request.Builder builder = this.create();
            final okhttp3.Request request = builder.method("get", RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)).build();
            return new MyResponse(newCall(request));
        }

        @Override
        public Response postForm() throws IOException {
            final okhttp3.Request.Builder builder = this.create();
            final okhttp3.Request request = builder.post(formBodyBuilder.build()).build();
            return new MyResponse(newCall(request));
        }

        @Override
        public Response post(String body) throws IOException {
            final okhttp3.Request.Builder builder = this.create();
            final okhttp3.Request request = builder.post(RequestBody.create(MediaType.parse(headerMap.get("Content-Type")), body)).build();
            return new MyResponse(newCall(request));
        }

        @Override
        public Response postJson(String json) throws IOException {
            final okhttp3.Request.Builder builder = this.create();
            final okhttp3.Request request = builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)).build();
            return new MyResponse(newCall(request));
        }

        @Override
        public Response postXml(String xml) throws IOException {
            final okhttp3.Request.Builder builder = this.create();
            final okhttp3.Request request = builder.post(RequestBody.create(MediaType.parse("application/xml charset=utf-8"), xml)).build();
            return new MyResponse(newCall(request));
        }

        @Override
        public Response putForm() throws IOException {
            final okhttp3.Request.Builder builder = this.create();
            final okhttp3.Request request = builder.put(formBodyBuilder.build()).build();
            return new MyResponse(newCall(request));
        }

        @Override
        public Response putJson(String json) throws IOException {
            final okhttp3.Request.Builder builder = this.create();
            final okhttp3.Request request = builder.put(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)).build();
            return new MyResponse(newCall(request));
        }

        @Override
        public Response delete() throws IOException {
            final okhttp3.Request.Builder builder = this.create();
            final okhttp3.Request request = builder.delete().build();
            return new MyResponse(newCall(request));
        }

        @Override
        public Response deleteJson(String json) throws IOException {
            final okhttp3.Request.Builder builder = this.create();
            final okhttp3.Request request = builder.method("DELETE", RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)).build();
            return new MyResponse(newCall(request));
        }

        private okhttp3.Request.Builder create() {
            okhttp3.Request.Builder requestBuilder = new okhttp3.Request.Builder();
            headerMap.forEach(requestBuilder::header);
            requestBuilder.url(httpUrlBuilder.build());
            return requestBuilder;
        }

        private okhttp3.Response newCall(okhttp3.Request request) throws IOException {
            return okHttpClient.newCall(request).execute();
        }

    }

    private static class MyResponse implements Response {

        private final okhttp3.Response response;
        private byte[] bytes = null;

        private MyResponse(okhttp3.Response response) {
            this.response = response;
        }

        @Override
        public int statusCode() {
            return response.code();
        }

        @SneakyThrows
        @Override
        public byte[] body() {
            if (Objects.nonNull(bytes)) {
                return bytes;
            }
            final ResponseBody body = response.body();
            if (Objects.isNull(body)) {
                return null;
            }
            bytes = body.bytes();
            return bytes;
        }

        @Override
        public InputStream bodyStream() {
            final ResponseBody body = response.body();
            if (Objects.isNull(body)) {
                return null;
            }
            return body.byteStream();
        }

        @Override
        public Map<String, String> headers() {
            final Headers headers = response.headers();
            final Map<String, String> result = new HashMap<>(headers.size());
            headers.names().forEach(it -> result.put(it, headers.get(it)));
            return result;
        }

        @Override
        public String bodyString() {
            return bodyString(StandardCharsets.UTF_8);
        }

        @Override
        public String bodyString(Charset charset) {
            final byte[] bytes = body();
            if (Objects.isNull(bytes)) {
                return null;
            }
            return new String(bytes, charset);
        }
    }
}
