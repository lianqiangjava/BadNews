package com.lianqiang.badnews.module.live.presenter;

import com.lianqiang.badnews.base.BasePresenterImpl;
import com.lianqiang.badnews.callback.RequestCallback;
import com.lianqiang.badnews.data.service.LiveChatLBService;
import com.lianqiang.badnews.module.live.bean.LiveMsg;
import com.lianqiang.badnews.module.live.bean.LiveVideoInfor;
import com.lianqiang.badnews.module.live.view.ILiveRoomLBView;

import io.reactivex.disposables.Disposable;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/31.
 */

public class LiveRoomLBPresenter extends BasePresenterImpl<ILiveRoomLBView, Object> {

    private String mRoomId;
    private int mPage = 1;
    private boolean isRefresh = true;

    public LiveRoomLBPresenter(ILiveRoomLBView view, String roomId) {
        super(view);
        mRoomId = roomId;
    }

    /**
     * 获取视频信息
     */
    public void getVideoInfor() {
        LiveChatLBService.getVideoInfor(mRoomId, new RequestCallback<LiveVideoInfor>() {
            @Override
            public void onSubscribe(Disposable d) {
                LiveRoomLBPresenter.super.onSubscribe(d);
            }

            @Override
            public void onError(String msg) {
                LiveRoomLBPresenter.super.onError(msg);
            }

            @Override
            public void onComplete() {
                LiveRoomLBPresenter.super.onComplete();
            }

            @Override
            public void onSuccess(LiveVideoInfor data) {
                mView.setVideoInfor(data);
            }
        });
    }

    /**
     * 获取聊天消息
     * @param videoId
     */
    public void getLiveChat(String videoId) {

        LiveChatLBService.getLiveMsg(videoId, mPage, new RequestCallback<LiveMsg>() {
            @Override
            public void onSubscribe(Disposable d) {
                LiveRoomLBPresenter.super.onSubscribe(d);
            }

            @Override
            public void onError(String msg) {
                LiveRoomLBPresenter.super.onError(msg);
            }

            @Override
            public void onComplete() {
                LiveRoomLBPresenter.super.onComplete();
            }

            @Override
            public void onSuccess(LiveMsg data) {
                if (data != null && data.getResult().getList() != null) {
                    mPage++;
                }
                mView.setVidoChat(data,isRefresh);

            }
        });
    }


    /**
     * 刷新
     */
    public void setRefresh(String videoId){
        isRefresh = true;
        mPage = 1;
        getLiveChat(videoId);
    }
    /**
     * 加载更多
     * @param videoId
     */
    public void loadMoreChat(String videoId){
        isRefresh = false;
        getLiveChat(videoId);
    }

}
