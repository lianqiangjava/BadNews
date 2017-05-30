package com.lianqiang.badnews.base;

import android.support.v7.app.AppCompatActivity;


/**
 * Created by lianqiang on 2017/5/17.
 */
public class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{

    protected T presenter;

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError(String msg) {

    }
}
