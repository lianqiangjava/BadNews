package com.lianqiang.badnews.data.service;

import com.lianqiang.badnews.base.BaseSchedulerTransformer;
import com.lianqiang.badnews.callback.RequestCallback;
import com.lianqiang.badnews.data.Api;
import com.lianqiang.badnews.data.ResultObserver;
import com.lianqiang.badnews.data.retrofit.apiservice.RetrofitLiveLBService;
import com.lianqiang.badnews.data.retrofit.manager.RetrofitManager;
import com.lianqiang.badnews.module.live.bean.LiveMsg;
import com.lianqiang.badnews.module.live.bean.LiveVideoInfor;
import com.lianqiang.badnews.module.live.bean.User;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Describe: 直播数据来自luoboapi
 *
 * @author lianqiang on 2017/5/31.
 */

public class LiveChatLBService {

    private static RetrofitLiveLBService service = RetrofitManager.buildService(Api.LIVE_CHAT_LB_HOST, RetrofitLiveLBService.class);


    /**
     * 获取直播视频信息
     * @param roomId
     * @param callback
     */
    public static void getVideoInfor(final String roomId,RequestCallback callback) {
        service.getUserId()
                .flatMap(new Function<User, Observable<LiveVideoInfor>>() {
                    @Override
                    public Observable<LiveVideoInfor> apply(User user) throws Exception {
                        return service.getVideoInfor(roomId, 10, 1, user.getResult().getUser_id());
                    }
                })
                .compose(new BaseSchedulerTransformer<LiveVideoInfor>())
                .subscribe(new ResultObserver<>(callback));
    }

    /**
     * 获取直播聊天消息
     * @param videoId
     * @param page
     * @param callback
     */
    public static void getLiveMsg(String videoId,int page,RequestCallback callback){
        service.getLiveMsg(videoId,10,10,page)
                .compose(new BaseSchedulerTransformer<LiveMsg>())
                .subscribe(new ResultObserver<>(callback));
    }

}
