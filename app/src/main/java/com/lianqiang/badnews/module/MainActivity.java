package com.lianqiang.badnews.module;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.module.live.ui.LiveFragment;
import com.lianqiang.badnews.module.news.ui.NewsFragment;
import com.lianqiang.badnews.module.video.ui.VideoFragment;
import com.lianqiang.badnews.utils.ViewUtil;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab_buttom)
    TabLayout tabLayout;
    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.video_full_container)
    FrameLayout videoFullContainer;

    FragmentManager manager;
    NewsFragment newsFragment;
    LiveFragment liveFragment;
    VideoFragment videoFragment;

    private final String[] tags = new String[]{
            "newsFragment","liveFragment","videoFragment","myFragment"
    };

    private static final int[] TAB_TITLES = new int[]{
            R.string.tab_home, R.string.tab_live,
            R.string.tab_vedio, R.string.tab_my
    };

    private static final int[] TAB_IMGS = new int[]{
            R.drawable.tab_home_selector, R.drawable.tab_live_selector,
            R.drawable.tab_video_selector, R.drawable.tab_my_selector
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

        if(savedInstanceState != null){
            newsFragment = (NewsFragment) manager.findFragmentByTag(tags[0]);
            liveFragment = (LiveFragment) manager.findFragmentByTag(tags[1]);
            videoFragment = (VideoFragment) manager.findFragmentByTag(tags[2]);
        }

        changeTab(0);
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(this);
        manager = getSupportFragmentManager();

        for (int i = 0; i < TAB_TITLES.length; i++) {
            View view = inflater.inflate(R.layout.tab_menu, null);
            TabLayout.Tab tab = tabLayout.newTab();
            TextView title = (TextView) view.findViewById(R.id.tab_title);
            ImageView img = (ImageView) view.findViewById(R.id.tab_img);
            title.setText(TAB_TITLES[i]);
            img.setImageResource(TAB_IMGS[i]);

            tab.setCustomView(view);
            tabLayout.addTab(tab);
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeTab(tab.getPosition());
                tab.getCustomView().setSelected(true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().setSelected(false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //播放视频设置全屏视图
        ViewUtil.setVideoFullContainer(videoFullContainer);

    }

    private void changeTab(int position) {
        FragmentTransaction ft = manager.beginTransaction();
        hideAll(ft);
        switch (position) {
            case 0:
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    ft.add(R.id.main_container, newsFragment,tags[position]);
                } else {
                    ft.show(newsFragment);
                }
                break;
            case 1:
                if (liveFragment == null) {
                    liveFragment = new LiveFragment();
                    ft.add(R.id.main_container, liveFragment,tags[position]);
                } else {
                    ft.show(liveFragment);
                }
                break;
            case 2:
                if (videoFragment == null) {
                    videoFragment = new VideoFragment();
                    ft.add(R.id.main_container, videoFragment,tags[position]);
                } else {
                    ft.show(videoFragment);
                }
                break;
            case 3:

                break;
        }
        ft.commit();
    }

    private void hideAll(FragmentTransaction ft) {
        if (newsFragment != null) {
            ft.hide(newsFragment);
        }
        if (liveFragment != null) {
            ft.hide(liveFragment);
        }
        if (videoFragment != null) {
            ft.hide(videoFragment);
        }
    }

}
