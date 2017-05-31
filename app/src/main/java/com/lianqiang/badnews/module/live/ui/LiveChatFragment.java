package com.lianqiang.badnews.module.live.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.base.BaseFragment;
import com.lianqiang.badnews.base.BaseRecyclerAdapter;
import com.lianqiang.badnews.base.BaseViewHolder;
import com.lianqiang.badnews.module.live.bean.LiveChat;
import com.lianqiang.badnews.module.live.bean.LiveChatTopic;
import com.lianqiang.badnews.module.live.bean.LiveUserCount;
import com.lianqiang.badnews.module.live.presenter.LiveRoomPresenter;
import com.lianqiang.badnews.module.live.view.ILiveRoomView;
import com.lianqiang.badnews.utils.GlideUtil;
import com.lianqiang.badnews.utils.TimeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * 直播聊天室
 */
public class LiveChatFragment extends BaseFragment<LiveRoomPresenter> implements ILiveRoomView, BGARefreshLayout.BGARefreshLayoutDelegate {

    public static final String CHAT_ANCHOR = "CHAT_ANCHOR";//主播聊天内容
    public static final String CHAT_TOPIC = "CHAT_TOPIC";//聊天话题内容

    private static final String ROOM_ID = "roomId";
    private static final String CHAT_TYPE = "chatType";

    @BindView(R.id.news_recycle)
    RecyclerView chatRecycle;
    @BindView(R.id.refresh_layout)
    BGARefreshLayout refreshLayout;
    Unbinder unbinder;

    private String mRoomId;
    private String mChatType = CHAT_ANCHOR;

    public LiveChatFragment() {
        // Required empty public constructor
    }

    public static LiveChatFragment newInstance(String roomid, String chatType) {
        LiveChatFragment fragment = new LiveChatFragment();
        Bundle args = new Bundle();
        args.putString(ROOM_ID, roomid);
        args.putString(CHAT_TYPE, chatType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRoomId = getArguments().getString(ROOM_ID);
            mChatType = getArguments().getString(CHAT_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_chat, null);
        unbinder = ButterKnife.bind(this, view);
        initRefreshLayout();

        presenter = new LiveRoomPresenter(this, mRoomId, mChatType);

        refreshLayout.beginRefreshing();

        return view;
    }

    private void initRefreshLayout() {
        refreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), true);
        refreshLayout.setRefreshViewHolder(refreshViewHolder);
        refreshViewHolder.setLoadingMoreText("加载更多...");
        refreshViewHolder.setLoadMoreBackgroundColorRes(R.color.colorAccent);
        refreshViewHolder.setLoadMoreBackgroundDrawableRes(R.mipmap.ic_launcher);
        refreshViewHolder.setRefreshViewBackgroundDrawableRes(R.mipmap.ic_launcher);

        chatRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onError(String msg) {
        endRefresh();
        Snackbar.make(refreshLayout, msg, 1000).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface VideoInfoCallBack {
        void setVideoInfor();
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {
        presenter.getLiveInfo();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return false;
    }

    private void endRefresh() {
        refreshLayout.endRefreshing();
        refreshLayout.endLoadingMore();
    }

    @Override
    public void setLiveInfo(LiveChat liveChat) {
        endRefresh();
        if (liveChat != null && liveChat.getMessages() != null) {
            chatRecycle.setAdapter(new BaseRecyclerAdapter<LiveChat.MessagesBean>(getContext(), R.layout.item_live_room_chat, liveChat.getMessages()) {
                @Override
                public void onBind(BaseViewHolder holder, LiveChat.MessagesBean message) {
                    //发布时间
                    holder.setText(R.id.msg_time, TimeUtil.strFormat(message.getTime()));
                    if (message.getCommentator() != null) {
                        //主播昵称
                        holder.setText(R.id.user_nick_name, message.getCommentator().getName());
                        if (!TextUtils.isEmpty(message.getCommentator().getImgUrl())) {
                            //主播头像
                            GlideUtil.getImg(getContext(), message.getCommentator().getImgUrl(), (ImageView) holder.getView(R.id.user_face));
                        }
                    }
                    //消息内容
                    if (message.getMsg() != null) {
                        holder.setText(R.id.msg_content, message.getMsg().getContent());
                    }
                    //发布的图片
                    if (message.getImages() != null) {
                        holder.getView(R.id.msg_img).setVisibility(View.VISIBLE);
                        GlideUtil.getImg(getContext(), message.getImages().get(0).getFullSizeSrc(), (ImageView) holder.getView(R.id.msg_img));
                    } else {
                        holder.getView(R.id.msg_img).setVisibility(View.GONE);
                    }
                    //回复
                    if (message.getQuote() != null) {
                        holder.getView(R.id.quote_layer).setVisibility(View.VISIBLE);
                        holder.setText(R.id.quote_user, message.getQuote().getNick_name());
                        holder.setText(R.id.quote_time, TimeUtil.getTimeByLong(message.getQuote().getTime()));
                        holder.setText(R.id.quote_msg, message.getQuote().getMsg());
                    } else {
                        holder.getView(R.id.quote_layer).setVisibility(View.GONE);
                    }

                }
            });
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
        endRefresh();
        if (liveTopic != null && liveTopic.getLast_log() != null) {
            chatRecycle.setAdapter(new BaseRecyclerAdapter<LiveChatTopic.LastLogBean>(getContext(), R.layout.item_live_room_chat, liveTopic.getLast_log()) {
                @Override
                public void onBind(BaseViewHolder holder, LiveChatTopic.LastLogBean message) {
                    //发布时间
                    holder.setText(R.id.msg_time, TimeUtil.getTimeByLong(message.getTime()));
                    //主播昵称
                    holder.setText(R.id.user_nick_name, message.getNick_name());
                    if (!TextUtils.isEmpty(message.getAvatar())) {
                        //主播头像
                        GlideUtil.getImg(getContext(), message.getAvatar(), (ImageView) holder.getView(R.id.user_face));
                    }
                    //消息内容
                    holder.setText(R.id.msg_content, message.getMsg());

                    //回复
                    if (message.getQuote() != null) {
                        holder.getView(R.id.quote_layer).setVisibility(View.VISIBLE);
                        holder.setText(R.id.quote_user, message.getQuote().getNick_name());
                        holder.getView(R.id.quote_time).setVisibility(View.GONE);
                        holder.setText(R.id.quote_msg, message.getQuote().getMsg());
                    } else {
                        holder.getView(R.id.quote_layer).setVisibility(View.GONE);
                    }

                }
            });
        }
    }
}
