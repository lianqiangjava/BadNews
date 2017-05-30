package com.lianqiang.badnews.data.retrofit.interceptor;

import android.os.Build;
import android.webkit.WebSettings;

import com.lianqiang.badnews.common.MApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TODO 指定用户代理拦截
 * Created by lianqiang on 2017/5/17.
 */

public class UserAgentInterceptor implements Interceptor{

    private static final String USER_AGENT_HEADER_NAME = "User-Agent";

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request originalRequest = chain.request();
        final Request requestWithUserAgent = originalRequest.newBuilder()
                .removeHeader(USER_AGENT_HEADER_NAME)
                .addHeader(USER_AGENT_HEADER_NAME, getUserAgent())
                .build();
        return chain.proceed(requestWithUserAgent);
    }

    private static String getUserAgent() {
        String userAgent = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            try {
                userAgent = WebSettings.getDefaultUserAgent(MApplication.getContext());
            } catch (Exception e) {
                userAgent = System.getProperty("http.agent");
            }
        } else {
            userAgent = System.getProperty("http.agent");
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0, length = userAgent.length(); i < length; i++) {
            char c = userAgent.charAt(i);
            if (c <= '\u001f' || c >= '\u007f') {
                sb.append(String.format("\\u%04x", (int) c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
