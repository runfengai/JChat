package com.jarry.jchat.utils.net;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jarry on 2018/3/25.
 */

public class BaseInterceptor implements Interceptor {

    private Map<String, String> headers;

    public BaseInterceptor() {
    }

    public BaseInterceptor(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request()
                .newBuilder();
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String headerKey : keys) {
                builder.addHeader(headerKey, headers.get(headerKey)).build();
            }
        } else {//加载默认的header
            builder.addHeader("Content-Type", "application/json;charset=UTF-8")
                    .addHeader("Accept-Encoding", "gzip, deflate")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("Accept", "text/html,*/*")
                    .addHeader("Cookie", "")
                    .build();
        }
        return chain.proceed(builder.build());

    }
}
