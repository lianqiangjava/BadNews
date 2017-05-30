package com.lianqiang.badnews.common;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * TODO
 * Created by lianqiang on 2017/5/17.
 */

public class MApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        LeakCanary.install(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
