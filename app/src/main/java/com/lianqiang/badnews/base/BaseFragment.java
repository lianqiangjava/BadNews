package com.lianqiang.badnews.base;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.common.MApplication;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * Created by lianqiang on 2017/5/17.
 */

public class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {

    private Activity activity;
    protected T presenter;
    protected View mFragmentRootView;
    protected int mContentViewId = R.layout.fragment_news;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == mFragmentRootView) {
            mFragmentRootView = inflater.inflate(mContentViewId, null);
            initView(mFragmentRootView);
        }

        Log.e("BaseFrg", "onCreateView: 调用");
        return mFragmentRootView;
    }


    public void setContentView(@LayoutRes int layoutResID) {
        mContentViewId = layoutResID;
    }

    protected void initView(View view) {

    }




    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError(String msg) {

    }

    public Context getContext() {
        if (activity == null) {
            return MApplication.getContext();
        }
        return activity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    public void startActivity(Bundle bundle, Class clazz) {
        Intent intent = new Intent(activity, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

}
