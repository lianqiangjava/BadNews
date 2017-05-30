package com.lianqiang.badnews.data.retrofit.manager;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lianqiang.badnews.data.Api;
import com.lianqiang.badnews.data.retrofit.interceptor.CacheControlInterceptor;
import com.lianqiang.badnews.data.retrofit.interceptor.UserAgentInterceptor;
import com.lianqiang.badnews.common.MApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * TODO 构造RetrofitService
 * Created by lianqiang on 2017/5/17.
 */

public class RetrofitManager {

    private static volatile OkHttpClient mOkHttpClient;

    public static <T> T buildService(Class<T> serviceClass){
        return buildService(Api.NETEAST_HOST,serviceClass);
    }


    public static <T> T buildService(String baseUrl, Class<T> serviceClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return (T) retrofit.create(serviceClass);
    }


    /**
     * 获取OkHttpClient
     * @return
     */
    private static OkHttpClient getOkHttpClient(){
        if(mOkHttpClient == null){
            synchronized(RetrofitManager.class){
                if (mOkHttpClient == null){

                    //缓存文件
                    File cacheFile = new File(MApplication.getContext().getExternalCacheDir().toString(),"news_cache");
                    //缓存大小为10M
                    int cacheSize = 10 * 1024 * 1024;
                    Cache cache = new Cache(cacheFile,cacheSize);

                    //在日志中打印http消息体
                    HttpLoggingInterceptor bodyInterceptor = new HttpLoggingInterceptor();
                    bodyInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                    //缓存控制
                    CacheControlInterceptor cacheControlInterceptor = new CacheControlInterceptor();

                    mOkHttpClient = new OkHttpClient.Builder().cache(cache)
                            .addNetworkInterceptor(cacheControlInterceptor)
                            .addInterceptor(cacheControlInterceptor)
                            .addInterceptor(bodyInterceptor)
                            .addInterceptor(new UserAgentInterceptor())
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30,TimeUnit.SECONDS).build();

                }
            }
        }

        return mOkHttpClient;
    }

}
