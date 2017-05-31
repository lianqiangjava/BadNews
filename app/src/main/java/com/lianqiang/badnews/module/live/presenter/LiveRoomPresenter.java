package com.lianqiang.badnews.module.live.presenter;

import com.lianqiang.badnews.base.BasePresenterImpl;
import com.lianqiang.badnews.module.live.bean.LiveChat;
import com.lianqiang.badnews.module.live.bean.LiveChatTopic;
import com.lianqiang.badnews.module.live.bean.LiveUserCount;
import com.lianqiang.badnews.callback.RequestCallback;
import com.lianqiang.badnews.data.service.LiveChatService;
import com.lianqiang.badnews.data.service.LiveVideoService;
import com.lianqiang.badnews.module.live.ui.LiveChatFragment;
import com.lianqiang.badnews.module.live.view.ILiveRoomView;

import io.reactivex.disposables.Disposable;

/**
 * Describe:直播室业务
 *
 * @author lianqiang on 2017/5/29.
 */

public class LiveRoomPresenter extends BasePresenterImpl<ILiveRoomView, LiveChat> {

    private String mRoomId;//房间ID
    private String mChatType;//主播/所有用户消息
    private int mChatPage;
    private int mTopicPage;

    public LiveRoomPresenter(ILiveRoomView view, String roomId,String chatTpye) {
        super(view);
        mRoomId = roomId;
        mChatType = chatTpye;
    }

    /**
     * 获取直播内容信息及聊天记录
     */
    public void getLiveInfo() {
        //获取主播消息
        if(LiveChatFragment.CHAT_ANCHOR.equals(mChatType)){
            LiveVideoService.getChatAll(mRoomId,mChatPage, new RequestCallback<LiveChat>() {
                @Override
                public void onSubscribe(Disposable d) {
                    LiveRoomPresenter.super.onSubscribe(d);
                }

                @Override
                public void onError(String msg) {
                    LiveRoomPresenter.super.onError(msg);
                }

                @Override
                public void onComplete() {
                    LiveRoomPresenter.super.onComplete();
                }

                @Override
                public void onSuccess(LiveChat data) {
                    if(data!=null){
                        mChatPage = data.getNextPage();
                    }
                    mView.setLiveInfo(data);
                }
            });
        }else {//获取话题消息
            LiveChatService.getTopicById(mRoomId, new RequestCallback<LiveChatTopic>() {
                @Override
                public void onSubscribe(Disposable d) {
                    LiveRoomPresenter.super.onSubscribe(d);
                }

                @Override
                public void onError(String msg) {
                    LiveRoomPresenter.super.onError(msg);
                }

                @Override
                public void onComplete() {
                    LiveRoomPresenter.super.onComplete();
                }

                @Override
                public void onSuccess(LiveChatTopic data) {
                    mView.setLiveTopic(data);
                }
            });
        }

    }

    /**
     * 获取最新聊天记录
     */
    public void getItemLive() {
        LiveVideoService.getChat(mRoomId, new RequestCallback<LiveChat>() {
            @Override
            public void onSubscribe(Disposable d) {
                LiveRoomPresenter.super.onSubscribe(d);
            }

            @Override
            public void onError(String msg) {
                LiveRoomPresenter.super.onError(msg);
            }

            @Override
            public void onComplete() {
                LiveRoomPresenter.super.onComplete();
            }

            @Override
            public void onSuccess(LiveChat data) {
                mView.updateItemChat(data);
            }
        });
    }

    /**
     * 获取参与人数
     */
    public void getUserCount() {
        LiveVideoService.getLiveUserCount(mRoomId, new RequestCallback<LiveUserCount>() {
            @Override
            public void onSubscribe(Disposable d) {
                LiveRoomPresenter.super.onSubscribe(d);
            }

            @Override
            public void onError(String msg) {
                LiveRoomPresenter.super.onError(msg);
            }

            @Override
            public void onComplete() {
                LiveRoomPresenter.super.onComplete();
            }

            @Override
            public void onSuccess(LiveUserCount data) {
                mView.updateUserCount(data);
            }
        });
    }


}
