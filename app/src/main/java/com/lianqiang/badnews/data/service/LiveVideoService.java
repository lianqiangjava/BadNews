package com.lianqiang.badnews.data.service;

import com.lianqiang.badnews.base.BaseSchedulerTransformer;
import com.lianqiang.badnews.module.live.bean.LiveChat;
import com.lianqiang.badnews.module.live.bean.LiveUserCount;
import com.lianqiang.badnews.module.live.bean.LiveVideo;
import com.lianqiang.badnews.callback.RequestCallback;
import com.lianqiang.badnews.data.Api;
import com.lianqiang.badnews.data.ResultObserver;
import com.lianqiang.badnews.data.retrofit.apiservice.RetrofitLiveService;
import com.lianqiang.badnews.data.retrofit.manager.RetrofitManager;

/**
 * Describe: 直播接口
 *
 * @author lianqiang on 2017/5/27.
 */

public class LiveVideoService {

    private static RetrofitLiveService service = RetrofitManager.buildService(Api.LIVE_VIDEO_HOST,RetrofitLiveService.class);

    /**
     * 获取直播列表数据
     * @param callback
     */
    public static void getLiveList(int page,RequestCallback callback){
        service.getLiveList(page)
                .compose(new BaseSchedulerTransformer<LiveVideo>())
                .subscribe(new ResultObserver<>(callback));
    }

    /**
     * 获取当前直播房间所有聊天记录
     * @param roomId
     * @param callback
     */
    public static void getChatAll(String roomId,int page,RequestCallback callback){
        if(page ==0 ){
            service.getChatAll(roomId)
                    .compose(new BaseSchedulerTransformer<LiveChat>())
                    .subscribe(new ResultObserver<>(callback));
        }else {
            service.getChatAll(roomId,page)
                    .compose(new BaseSchedulerTransformer<LiveChat>())
                    .subscribe(new ResultObserver<>(callback));
        }

    }

    /**
     * 获取当前直播房间实时聊天记录
     * @param roomId
     * @param callback
     */
    public static void getChat(String roomId,RequestCallback callback){
        service.getChat(roomId)
                .compose(new BaseSchedulerTransformer<LiveChat>())
                .subscribe(new ResultObserver<>(callback));
    }

    /**
     * 获取当前直播参与人数
     * @param roomId
     * @param callback
     */
    public static void getLiveUserCount(String roomId,RequestCallback callback){
        service.getLiveUserCount(roomId)
                .compose(new BaseSchedulerTransformer<LiveUserCount>())
                .subscribe(new ResultObserver<>(callback));
    }


}
