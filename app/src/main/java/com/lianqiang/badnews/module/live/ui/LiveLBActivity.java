package com.lianqiang.badnews.module.live.ui;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.base.BaseActivity;
import com.lianqiang.badnews.base.BaseRecyclerAdapter;
import com.lianqiang.badnews.base.BaseViewHolder;
import com.lianqiang.badnews.module.live.bean.LiveMsg;
import com.lianqiang.badnews.module.live.bean.LiveVideoInfor;
import com.lianqiang.badnews.module.live.presenter.LiveRoomLBPresenter;
import com.lianqiang.badnews.module.live.view.ILiveRoomLBView;
import com.lianqiang.badnews.utils.GlideUtil;
import com.shuyu.gsyvideoplayer.GSYPreViewManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * 直播室-livetype=1时
 */
public class LiveLBActivity extends BaseActivity<LiveRoomLBPresenter> implements ILiveRoomLBView, BGARefreshLayout.BGARefreshLayoutDelegate {

    @BindView(R.id.live_palyer)
    StandardGSYVideoPlayer livePalyer;
    @BindView(R.id.news_recycle)
    RecyclerView chatRecycle;
    @BindView(R.id.refresh_layout)
    BGARefreshLayout refreshLayout;

    private String mRoomId;
    private String mVideoId;
    private OrientationUtils orientationUtils;
    private List<LiveMsg.ResultBean.ListBean> listMsg = new ArrayList<>();
    private BaseRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_lb);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {

        initRefreshLayout();

        livePalyer.getBackButton().setVisibility(View.VISIBLE);
        livePalyer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        orientationUtils = new OrientationUtils(this, livePalyer);
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
                livePalyer.startWindowFullscreen(LiveLBActivity.this, true, true);
            }
        });

    }

    private void initData() {
        mRoomId = getIntent().getExtras().getString("roomId");
        presenter = new LiveRoomLBPresenter(this, mRoomId);
        presenter.getVideoInfor();
    }

    private void initRefreshLayout() {
        refreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);
        refreshLayout.setRefreshViewHolder(refreshViewHolder);
        refreshViewHolder.setLoadingMoreText("加载更多...");
        refreshViewHolder.setLoadMoreBackgroundColorRes(R.color.colorAccent);
        refreshViewHolder.setLoadMoreBackgroundDrawableRes(R.mipmap.ic_launcher);
        refreshViewHolder.setRefreshViewBackgroundDrawableRes(R.mipmap.ic_launcher);

        chatRecycle.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BaseRecyclerAdapter<LiveMsg.ResultBean.ListBean>(this,R.layout.item_chat_msg,listMsg) {
            @Override
            public void onBind(BaseViewHolder viewHolder, LiveMsg.ResultBean.ListBean bean) {

                GlideUtil.getImg(LiveLBActivity.this, bean.getSenderUser().getAvatar(), (ImageView) viewHolder.getView(R.id.chat_head));

                viewHolder.setText(R.id.chat_user_name,bean.getSenderUser().getNickname()+":");
                viewHolder.setText(R.id.chat_msg,bean.getMessage());

            }
        };

        chatRecycle.setAdapter(adapter);

    }

    @Override
    public void setVideoInfor(LiveVideoInfor videoInfor) {
        if (videoInfor != null && videoInfor.getResult() != null) {
            mVideoId = videoInfor.getResult().getVideo().getVideo_id() + "";
            livePalyer.setUp(videoInfor.getResult().getVideo().getWeb_url(), true, "");

            livePalyer.startPlayLogic();
            livePalyer.getBackButton().setVisibility(View.VISIBLE);

            refreshLayout.beginRefreshing();
        }
    }

    @Override
    public void setVidoChat(LiveMsg liveMsg,boolean isRefresh) {
        endRefresh();
        if (liveMsg != null && liveMsg.getResult().getList() != null){
//            chatRecycle.setAdapter(new BaseRecyclerAdapter<LiveMsg.ResultBean.ListBean>(this,R.layout.item_chat_msg,liveMsg.getResult().getList()) {
//                @Override
//                public void onBind(BaseViewHolder viewHolder, LiveMsg.ResultBean.ListBean bean) {
//
//                    GlideUtil.getImg(LiveLBActivity.this, bean.getSenderUser().getAvatar(), (ImageView) viewHolder.getView(R.id.chat_head));
//
//                    viewHolder.setText(R.id.chat_user_name,bean.getSenderUser().getNickname()+":");
//                    viewHolder.setText(R.id.chat_msg,bean.getMessage());
//
//                }
//
//            });
            if(isRefresh){
                adapter.setData(liveMsg.getResult().getList());
            }else {
                adapter.loadMore(liveMsg.getResult().getList());
            }

        }
    }

    @Override
    public void onError(String msg) {
        super.onError(msg);
        endRefresh();
        Snackbar.make(refreshLayout, msg, 1000).show();
    }

    private void endRefresh(){
        refreshLayout.endRefreshing();
        refreshLayout.endLoadingMore();
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {
        presenter.setRefresh(mVideoId);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        presenter.loadMoreChat(mVideoId);
        return false;
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
                livePalyer.startWindowFullscreen(LiveLBActivity.this, true, true);
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
}
