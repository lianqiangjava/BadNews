package com.lianqiang.badnews.module.video.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.base.BaseFragment;
import com.lianqiang.badnews.module.video.bean.VideoList;
import com.lianqiang.badnews.module.video.adapter.VideoRecyclerAdapter;
import com.lianqiang.badnews.module.video.presenter.VideoPresenter;
import com.lianqiang.badnews.module.video.view.IVideoListView;
import com.lianqiang.badnews.utils.ViewUtil;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * Describe: 视频列表
 *
 * @author lianqiang on 2017/5/25.
 */

public class VideoListFragment extends BaseFragment<VideoPresenter> implements IVideoListView,BGARefreshLayout.BGARefreshLayoutDelegate {

    private static final String TAG = "VideoListFragment";

    private static final String CHANNEL_ID = "channel_id";

    private String mChanelId;

    protected BGARefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<VideoList> videoLists = new ArrayList<>();
    private VideoRecyclerAdapter adapter;
    private static ListVideoUtil listVideoUtil;
    private int lastVisibleItem;
    private int firstVisibleItem;

    private boolean isLoad = false;//如果调用过接口，再次返回到此界面时默认显示上次数据

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            mChanelId = getArguments().getString(CHANNEL_ID);
        }
    }

    @Override
    protected void initView(View view) {
        initRefreshLayout(view);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView)view.findViewById(R.id.news_recycle);
        recyclerView.setLayoutManager(linearLayoutManager);

        listVideoUtil = ViewUtil.getListVideoUtil(getActivity());
        adapter = new VideoRecyclerAdapter(getActivity(),videoLists,listVideoUtil);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem   = linearLayoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                //大于0说明有播放,//对应的播放列表TAG
                if (listVideoUtil.getPlayPosition() >= 0 && listVideoUtil.getPlayTAG().equals(VideoRecyclerAdapter.TAG)) {
                    //当前播放的位置
                    int position = listVideoUtil.getPlayPosition();
                    //不可视的时候
                    if ((position < firstVisibleItem || position > lastVisibleItem)) {
                        releaseVideos();
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        presenter = new VideoPresenter(this,mChanelId);

        //只有当前界面显示此Fragment时，才请求数据接口
        if(getUserVisibleHint()){
//            presenter.refreshData();
            refreshLayout.beginRefreshing();
        }
    }

    private void initRefreshLayout(View view) {
        refreshLayout = (BGARefreshLayout) view.findViewById(R.id.refresh_layout);
        if (refreshLayout != null) {
            refreshLayout.setDelegate(this);
            BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), true);
            refreshLayout.setRefreshViewHolder(refreshViewHolder);
            refreshViewHolder.setLoadingMoreText("加载更多...");
            refreshViewHolder.setLoadMoreBackgroundColorRes(R.color.colorAccent);
            refreshViewHolder.setLoadMoreBackgroundDrawableRes(R.mipmap.ic_launcher);
            refreshViewHolder.setRefreshViewBackgroundDrawableRes(R.mipmap.ic_launcher);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser && presenter !=null && !isLoad){
//            presenter.refreshData();
            refreshLayout.beginRefreshing();
        }

        //切换Fragment时释放正在播放的视频
        if(isVisibleToUser){
            releaseVideos();
            if(adapter !=null){
                adapter.notifyDataSetChanged();
            }
        }

    }

    public static VideoListFragment newInstance(String channelId){
        Bundle bundle = new Bundle();
        bundle.putString(CHANNEL_ID,channelId);
        VideoListFragment videoListFragment = new VideoListFragment();
        videoListFragment.setArguments(bundle);
        return videoListFragment;
    }



    @Override
    public void updateVideoList(List<VideoList> data, boolean isRefresh) {
        isLoad = true;
        if(isRefresh){
            refreshLayout.endRefreshing();
            adapter.setData(data);
        }else {
            refreshLayout.endLoadingMore();
            adapter.addMoreData(data);
        }
    }

    @Override
    public void onError(String msg) {
        refreshLayout.endRefreshing();
        refreshLayout.endLoadingMore();
        Snackbar.make(refreshLayout,msg,1000).show();
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        releaseVideos();
        presenter.refreshData();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        presenter.loadMore();
        return true;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        releaseVideos();
        ViewUtil.releaseVideoUtil();
    }

    private void releaseVideos(){
        if(listVideoUtil!=null&&listVideoUtil.getPlayPosition() >= 0){
            listVideoUtil.releaseVideoPlayer();
            GSYVideoPlayer.releaseAllVideos();
        }
    }
}
