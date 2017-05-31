package com.lianqiang.badnews.module.live.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.base.BaseFragment;
import com.lianqiang.badnews.base.BaseRecyclerAdapter;
import com.lianqiang.badnews.base.BaseViewHolder;
import com.lianqiang.badnews.module.live.bean.LiveVideo;
import com.lianqiang.badnews.module.live.presenter.LivePresenter;
import com.lianqiang.badnews.module.live.view.ILiveView;
import com.lianqiang.badnews.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * 直播列表
 */
public class LiveFragment extends BaseFragment<LivePresenter> implements ILiveView, BGARefreshLayout.BGARefreshLayoutDelegate {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.news_recycle)
    RecyclerView liveRecycle;
    @BindView(R.id.refresh_layout)
    BGARefreshLayout refreshLayout;
    Unbinder unbinder;
    private List<LiveVideo.LiveReviewBean> reviewBeanList = new ArrayList<LiveVideo.LiveReviewBean>();
    private BaseRecyclerAdapter<LiveVideo.LiveReviewBean> adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = inflater.inflate(R.layout.fragment_live, null);

        unbinder = ButterKnife.bind(this, rootView);
        initView(rootView);
        return rootView;
    }

    @Override
    protected void initView(View view) {

        initRefreshLayout(view);
        liveRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new BaseRecyclerAdapter<LiveVideo.LiveReviewBean>(getContext(), R.layout.item_live_list, reviewBeanList) {
            @Override
            public void onBind(BaseViewHolder holder, final LiveVideo.LiveReviewBean liveReviewBean) {

                //item背景图
                GlideUtil.getImg(getContext(), liveReviewBean.getImage(), (ImageView) holder.getView(R.id.live_list_bg));
                //直播来源信息
                if (liveReviewBean.getSourceinfo() != null) {
                    if (!TextUtils.isEmpty(liveReviewBean.getSourceinfo().getTimg())) {
                        GlideUtil.getImg(getContext(), liveReviewBean.getSourceinfo().getTimg(), (ImageView) holder.getView(R.id.live_list_icon));
                    }
                    holder.setText(R.id.live_list_source, liveReviewBean.getSourceinfo().getTname());
                }
                //直播状态(0:预告，1:正在直播，2:直播结束)
                if (liveReviewBean.getLiveStatus() == 1) {
                    holder.setText(R.id.live_list_status, "直播");
                    holder.getView(R.id.live_list_status).setBackgroundResource(R.drawable.shape_rectangle_red);
                } else {
                    holder.setText(R.id.live_list_status, "回顾");
                    holder.getView(R.id.live_list_status).setBackgroundResource(R.drawable.shape_rectangle_gray);
                }
                //参与人数
                holder.setText(R.id.live_list_count, liveReviewBean.getUserCount() + "参与");
                //直播房间标题
                holder.setText(R.id.live_list_title, liveReviewBean.getRoomName());

                final String roomId = liveReviewBean.getRoomId() + "";
                //点击单项跳转到直播室
                holder.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("roomId", roomId);

                        if(liveReviewBean.getLiveType() == 0){
                            startActivity(bundle, LiveRoomActivity.class);
                        }else {
                            startActivity(bundle, LiveLBActivity.class);
                        }

                    }
                });

            }
        };

        liveRecycle.setAdapter(adapter);

        presenter = new LivePresenter(this);

        refreshLayout.beginRefreshing();
    }

    private void initRefreshLayout(View view) {
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
    public void updateLive(LiveVideo liveVideo, boolean isRefresh) {
        if (isRefresh) {
            refreshLayout.endRefreshing();
            adapter.setData(liveVideo.getLive_review());
        } else {
            refreshLayout.endLoadingMore();
            adapter.loadMore(liveVideo.getLive_review());
        }
    }

    @Override
    public void onError(String msg) {
        refreshLayout.endRefreshing();
        refreshLayout.endLoadingMore();
        Snackbar.make(refreshLayout, msg, 1000).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {
        presenter.refreshData();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        presenter.loadMore();
        return false;
    }

}
