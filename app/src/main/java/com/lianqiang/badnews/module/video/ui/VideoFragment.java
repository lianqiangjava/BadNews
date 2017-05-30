package com.lianqiang.badnews.module.video.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.base.BaseFragment;
import com.lianqiang.badnews.base.BaseFragmentAdapter;
import com.lianqiang.badnews.db.bean.TBVideoChannel;
import com.lianqiang.badnews.module.video.presenter.VideoChannelPresenter;
import com.lianqiang.badnews.module.video.view.IVideoChannelView;
import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Describe: 视频
 *
 * @author lianqiang on 2017/5/25.
 */

public class VideoFragment extends BaseFragment<VideoChannelPresenter> implements IVideoChannelView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.coord_layout)
    CoordinatorLayout coordLayout;
    Unbinder unbinder;

    private BaseFragmentAdapter fragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_news, null);
        unbinder = ButterKnife.bind(this, view);

        presenter = new VideoChannelPresenter(this);
        return view;
    }


    @Override
    public void updateAdapter(List<TBVideoChannel> channelList) {
        List<BaseFragment> baseFragments = new ArrayList<>();
        List<String> pageTitles = new ArrayList<>();
        if (fragmentAdapter == null) {
            for (TBVideoChannel videoChanel : channelList) {
                baseFragments.add(VideoListFragment.newInstance(videoChanel.channelId));
                pageTitles.add(videoChanel.channelName);
            }
            fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), baseFragments, pageTitles);
        } else {
            fragmentAdapter.updateAdapter(baseFragments, pageTitles);
        }
        viewpager.setAdapter(fragmentAdapter);
        tabs.setupWithViewPager(viewpager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
