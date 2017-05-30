package com.lianqiang.badnews.data.service;

import com.lianqiang.badnews.base.BaseSchedulerTransformer;
import com.lianqiang.badnews.module.live.bean.LiveChatTopic;
import com.lianqiang.badnews.callback.RequestCallback;
import com.lianqiang.badnews.data.Api;
import com.lianqiang.badnews.data.ResultObserver;
import com.lianqiang.badnews.data.retrofit.apiservice.RetrofitLiveChatService;
import com.lianqiang.badnews.data.retrofit.manager.RetrofitManager;

/**
 * Describe:获取直播话题数据
 *
 * @author lianqiang on 2017/5/30.
 */

public class LiveChatService {

    private static RetrofitLiveChatService service = RetrofitManager.buildService(Api.LIVE_CHAT_HOST,RetrofitLiveChatService.class);

    /**
     * 获取直播聊天话题
     * @param topicid
     * @param callback
     */
    public static void getTopicById(String topicid,RequestCallback callback){
        service.getTopicById(topicid)
                .compose(new BaseSchedulerTransformer<LiveChatTopic>())
                .subscribe(new ResultObserver<>(callback));
    }

    /**
     * 获取实时话题
     * @param start
     * @param userid
     * @param topicid
     * @param callback
     */
    public static void getRealTimeTopic(int start,String userid,String topicid,RequestCallback callback){
        service.getRealTimeTopic(start,userid,topicid,1)
                .compose(new BaseSchedulerTransformer<LiveChatTopic.RealTimeMsg>())
                .subscribe(new ResultObserver<>(callback));
    }

    /**
     * 加载更多之前消息
     * @param start
     * @param userid
     * @param topicid
     * @param callback
     */
    public static void getMoreTopic(int start,String userid,String topicid,RequestCallback callback){
        service.getMoreTopic(topicid,userid,1,start,20)
                .compose(new BaseSchedulerTransformer<LiveChatTopic.RealTimeMsg>())
                .subscribe(new ResultObserver<>(callback));
    }
}


