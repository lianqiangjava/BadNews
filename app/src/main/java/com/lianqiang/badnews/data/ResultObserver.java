package com.lianqiang.badnews.data;

import android.util.Log;

import com.lianqiang.badnews.callback.RequestCallback;
import com.lianqiang.badnews.common.MApplication;
import com.lianqiang.badnews.utils.NetWorkUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * TODO
 * Created by lianqiang on 2017/5/17.
 */

public class ResultObserver<T> implements Observer<T>{

    private RequestCallback<T> callback;

    public ResultObserver(RequestCallback<T> callback){
        this.callback = callback;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if(callback != null)
            callback.onSubscribe(d);
    }

    @Override
    public void onNext(@NonNull T t) {
        if(callback != null)
            callback.onSuccess(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (callback != null) {
            String errorMsg = null;
            if (e instanceof HttpException) {
                switch (((HttpException) e).code()) {
                    case 403:
                        errorMsg = "没有权限访问此链接！";
                        break;
                    case 504:
                        if (!NetWorkUtil.isConnected(MApplication.getContext())) {
                            errorMsg = "没有联网哦！";
                        } else {
                            errorMsg = "网络连接超时！";
                        }
                        break;
                    default:
                        errorMsg = ((HttpException) e).message();
                        break;
                }
            } else if (e instanceof UnknownHostException) {
                errorMsg = "不知名主机！";
            } else if (e instanceof SocketTimeoutException) {
                errorMsg = "网络连接超时！";
            }else if(e instanceof ConnectException){
                errorMsg = "网络连接失败！";
            }else {
                errorMsg = "未知异常！";
            }
            Log.e("ResultObserver",e.toString());
            callback.onError(errorMsg);
        }
    }

    @Override
    public void onComplete() {
        if(callback != null)
            callback.onComplete();
    }
}
