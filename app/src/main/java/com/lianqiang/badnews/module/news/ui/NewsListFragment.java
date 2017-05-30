package com.lianqiang.badnews.module.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.base.BaseFragment;
import com.lianqiang.badnews.module.news.bean.NewsList;
import com.lianqiang.badnews.module.news.adapter.NewsRecyclerAdapter;
import com.lianqiang.badnews.module.news.presenter.NewsListPresenter;
import com.lianqiang.badnews.module.news.view.INewsListView;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * Describe: 新闻列表
 *
 * @author lianqiang on 2017/5/19.
 */

public class NewsListFragment extends BaseFragment<NewsListPresenter> implements INewsListView,BGARefreshLayout.BGARefreshLayoutDelegate{

    private static final String TAG = "NewsListFragment";

    private static final String CHANNEL_TYPE = "channel_type";
    private static final String CHANNEL_ID = "channel_id";

    private String mChanelId;
    private String mChannelType;

    private BGARefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private NewsRecyclerAdapter adapter;
    private List<NewsList> newsLists = new ArrayList<NewsList>();

    private boolean isLoad = false;//如果调用过接口，再次返回到此界面时默认显示上次数据

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            mChanelId = getArguments().getString(CHANNEL_ID);
            mChannelType = getArguments().getString(CHANNEL_TYPE);
        }

        Log.e(TAG, "onCreate: 调用" );

    }

    public static NewsListFragment newInstance(String channelId,String channelType){
        Bundle bundle = new Bundle();
        bundle.putString(CHANNEL_ID,channelId);
        bundle.putString(CHANNEL_TYPE,channelType);
        NewsListFragment newsListFragment = new NewsListFragment();
        newsListFragment.setArguments(bundle);
        return newsListFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void initView(View view) {

        Log.e(TAG, "initView: 调用initView" );

        initRefreshLayout(view);

        recyclerView = (RecyclerView)view.findViewById(R.id.news_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsRecyclerAdapter(getActivity(),newsLists);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new NewsRecyclerAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String postid) {
                Bundle bundle = new Bundle();
                bundle.putString("postid",postid);
                startActivity(bundle,NewsDetailActivity.class);
            }
        });

        presenter = new NewsListPresenter(this,mChannelType,mChanelId);

        //只有当前界面显示此Fragment时，才请求数据接口
        if(getUserVisibleHint()){
            Log.e(TAG, "initView: 请求接口" );
            refreshLayout.beginRefreshing();
        }

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser && presenter !=null && !isLoad){
            Log.e(TAG, "setUserVisibleHint: 接口调用" );
            refreshLayout.beginRefreshing();
        }
    }

    private void initRefreshLayout(View view){
        refreshLayout = (BGARefreshLayout)view.findViewById(R.id.refresh_layout);
        refreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(),true);
        refreshLayout.setRefreshViewHolder(refreshViewHolder);
        refreshViewHolder.setLoadingMoreText("加载更多...");
        refreshViewHolder.setLoadMoreBackgroundColorRes(R.color.colorAccent);
        refreshViewHolder.setLoadMoreBackgroundDrawableRes(R.mipmap.ic_launcher);
        refreshViewHolder.setRefreshViewBackgroundDrawableRes(R.mipmap.ic_launcher);
    }


    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        presenter.refreshData();

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        presenter.loadMore();
        return true;
    }

    @Override
    public void updateNewsList(List<NewsList> data,boolean isRefresh) {
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
}
