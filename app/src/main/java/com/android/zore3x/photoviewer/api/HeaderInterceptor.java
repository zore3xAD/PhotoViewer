package com.android.zore3x.photoviewer.api;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    private String mClientId;

    public HeaderInterceptor(String clientId) {
        mClientId = clientId;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("Authorization", "Client-ID " + mClientId)
                .build();

        return chain.proceed(request);
    }
}
