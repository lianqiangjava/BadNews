package com.lianqiang.badnews.base;

/**
 * TODO 基类视图
 * Created by lianqiang on 2017/5/17.
 */

public interface BaseView {

    void showProgress();
    void hideProgress();
    void onError(String msg);
}
