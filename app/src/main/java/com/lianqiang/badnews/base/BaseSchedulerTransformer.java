package com.lianqiang.badnews.base;


import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * 线程调度
 * Created by lianqiang on 2017/5/17.
 */

public class BaseSchedulerTransformer<T> implements ObservableTransformer<T,T> {

    @Override
    public ObservableSource<T> apply(@NonNull io.reactivex.Observable<T> upstream) {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
