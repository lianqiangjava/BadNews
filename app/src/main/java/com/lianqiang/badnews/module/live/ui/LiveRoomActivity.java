package com.lianqiang.badnews.module.live.ui;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.base.BaseActivity;
import com.lianqiang.badnews.base.BaseFragment;
import com.lianqiang.badnews.base.BaseFragmentAdapter;
import com.lianqiang.badnews.module.live.bean.LiveChat;
import com.lianqiang.badnews.module.live.bean.LiveChatTopic;
import com.lianqiang.badnews.module.live.bean.LiveUserCount;
import com.lianqiang.badnews.module.live.presenter.LiveRoomPresenter;
import com.lianqiang.badnews.module.live.view.ILiveRoomView;
import com.shuyu.gsyvideoplayer.GSYPreViewManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 直播室-livetype=0时
 */
public class LiveRoomActivity extends BaseActivity<LiveRoomPresenter> implements ILiveRoomView {

    @BindView(R.id.live_palyer)
    StandardGSYVideoPlayer livePalyer;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private OrientationUtils orientationUtils;
    private BaseFragmentAdapter fragmentAdapter;
    private String roomId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_room);
        ButterKnife.bind(this);

        initView();

        roomId = getIntent().getExtras().getString("roomId");

        presenter = new LiveRoomPresenter(this, roomId,LiveChatFragment.CHAT_ANCHOR);

        presenter.getLiveInfo();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(livePalyer!=null){
            livePalyer.onVideoPause();
        }
    }


    private void initView(){
        livePalyer.getBackButton().setVisibility(View.VISIBLE);
        livePalyer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        orientationUtils = new OrientationUtils(this,livePalyer);
        orientationUtils.setEnable(false);
        //关闭自动旋转
        livePalyer.setRotateViewAuto(false);
        livePalyer.setLockLand(false);
        livePalyer.setShowFullAnimation(false);
        livePalyer.setNeedLockFull(true);
        livePalyer.setIsTouchWiget(false);
        livePalyer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientationUtils.resolveByClick();
                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                livePalyer.startWindowFullscreen(LiveRoomActivity.this, true, true);
            }
        });
    }

    @Override
    public void setLiveInfo(LiveChat liveChat) {
        //初始化Tab
        if (liveChat != null && liveChat.getTabs() != null && liveChat.getTabs().size() > 0) {
            List<BaseFragment> baseFragments = new ArrayList<>();
            List<String> pageTitles = new ArrayList<>();

            for (LiveChat.TabsBean tabsBean : liveChat.getTabs()) {
                baseFragments.add(LiveChatFragment.newInstance(roomId,tabsBean.getType() == 0 ? LiveChatFragment.CHAT_ANCHOR : LiveChatFragment.CHAT_TOPIC));
                pageTitles.add(tabsBean.getTitle());
            }
            fragmentAdapter = new BaseFragmentAdapter(getSupportFragmentManager(), baseFragments, pageTitles);

            viewpager.setAdapter(fragmentAdapter);
            tabs.setupWithViewPager(viewpager);
        }

        //初始化VideoPlayer
        if(liveChat !=null){
            String path = "";
            if(!TextUtils.isEmpty(liveChat.getLiveVideoUrl())){
                path = liveChat.getLiveVideoUrl();
            }else {
                if(liveChat.getMutilVideo()!=null){
                    path = liveChat.getMutilVideo().get(0).getUrl();
                }
            }
            Log.e("RRRR", "setAllLive: URL:"+ path);
            livePalyer.setUp(path,true,"");

            livePalyer.startPlayLogic();
            livePalyer.getBackButton().setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        //先返回正常状态
        if (orientationUtils.getScreenType() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            livePalyer.getFullscreenButton().performClick();
            return;
        }
        //释放所有
        livePalyer.setStandardVideoAllCallBack(null);
        GSYVideoPlayer.releaseAllVideos();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        GSYPreViewManager.instance().releaseMediaPlayer();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
            if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_USER) {
                if (!livePalyer.isIfCurrentIsFullscreen()) {
                    livePalyer.startWindowFullscreen(LiveRoomActivity.this, true, true);
                }
            } else {
                //新版本isIfCurrentIsFullscreen的标志位内部提前设置了，所以不会和手动点击冲突
                if (livePalyer.isIfCurrentIsFullscreen()) {
                    StandardGSYVideoPlayer.backFromWindowFull(this);
                }
                if (orientationUtils != null) {
                    orientationUtils.setEnable(true);
                }
            }
    }

    @Override
    public void updateItemChat(LiveChat liveChat) {

    }

    @Override
    public void updateUserCount(LiveUserCount liveUserCount) {

    }

    @Override
    public void setLiveTopic(LiveChatTopic liveTopic) {

    }

}
