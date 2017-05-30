package com.lianqiang.badnews.callback;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * TODO
 * Created by lianqiang on 2017/5/17.
 */

public interface RequestCallback<T> {

    /**
     * 请求开始前调用
     * @param d
     */
    void onSubscribe(@NonNull Disposable d);

    /**
     * 请求错误调用
     *
     * @param msg 错误信息
     */
    void onError(String msg);

    /**
     * 请求完成调用
     */
    void onComplete();

    /**
     * 请求成功调用
     *
     * @param data 数据
     */
    void onSuccess(T data);
}
