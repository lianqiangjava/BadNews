package com.lianqiang.badnews.base;

import com.lianqiang.badnews.callback.RequestCallback;

import java.io.BufferedReader;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Describe: 代理基类实现
 *
 * @author lianqiang on 2017/5/17.
 */

public class BasePresenterImpl<T extends BaseView, V> implements BasePresenter, RequestCallback<V> {

    protected Disposable disposable;
    protected T mView;

    public BasePresenterImpl(T view){
        mView = view;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        if(disposable !=null && !disposable.isDisposed()){
            disposable.dispose();
        }
        mView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        disposable = d;
        mView.showProgress();
    }

    @Override
    public void onError(String msg) {
        mView.hideProgress();
        mView.onError(msg);
    }

    @Override
    public void onComplete() {
        mView.hideProgress();
    }

    @Override
    public void onSuccess(V data) {

    }
}
