package com.lianqiang.badnews.data.retrofit.interceptor;

import com.lianqiang.badnews.common.MApplication;
import com.lianqiang.badnews.utils.NetWorkUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TODO 网络请求缓存控制
 * Created by lianqiang on 2017/5/17.
 */

public class CacheControlInterceptor implements Interceptor{

    // 设缓存有效期为两天
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    // 30秒内直接读缓存
    private static final long CACHE_AGE_SEC = 0;


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        // 在这里统一配置请求头缓存策略以及响应头缓存策略
        if (NetWorkUtil.isConnected(MApplication.getContext())) {
            // 在有网的情况下CACHE_AGE_SEC秒内读缓存，大于CACHE_AGE_SEC秒后会重新请求数据
            request = request.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control").header("Cache-Control", "public, max-age=" + CACHE_AGE_SEC).build();
            Response response = chain.proceed(request);
            return response.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control").header("Cache-Control", "public, max-age=" + CACHE_AGE_SEC).build();
        } else {
            // 无网情况下CACHE_STALE_SEC秒内读取缓存，大于CACHE_STALE_SEC秒缓存无效报504
            request = request.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC).build();
            Response response = chain.proceed(request);
            return response.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC).build();
        }
    }
}
