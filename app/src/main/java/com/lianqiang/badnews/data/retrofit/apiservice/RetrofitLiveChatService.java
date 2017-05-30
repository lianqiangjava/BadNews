package com.lianqiang.badnews.data.retrofit.apiservice;

import com.lianqiang.badnews.module.live.bean.LiveChatTopic;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Describe: 直播聊天内容
 *
 * @author lianqiang on 2017/5/30.
 */

public interface RetrofitLiveChatService {

    /**
     * 获取直播聊天话题
     * @param topicid
     * @return
     */
    @GET("route_room")
    Observable<LiveChatTopic> getTopicById(@Query("topicid") String topicid);

    /**
     * https://data.chat.126.net/chat_log?start=729&userid=5339&topicid=133822&roomid=1
     * 获取实时话题
     * @param start 最后一条消息id
     * @param userid NOTE: 此用户id是根据上个接口(getTopicById)返回的，此id是动态变化的，要根据上面接口获取最新userid
     * @param topicid
     * @return
     */
    @GET("chat_log")
    Observable<LiveChatTopic.RealTimeMsg> getRealTimeTopic(@Query("start") int start,
                                                           @Query("userid") String userid,
                                                           @Query("topicid") String topicid,
                                                           @Query("roomid") int roomid);

    /**
     * https://data.chat.126.net/chat_log?topicid=133333&userid=2795&roomid=1&start=330&len=20
     * 加载更多之前消息
     * @param topicid
     * @param userid
     * @param start
     * @return
     */
    @GET("chat_log")
    Observable<LiveChatTopic.RealTimeMsg> getMoreTopic(@Query("topicid") String topicid,
                                                       @Query("userid") String userid,
                                                       @Query("roomid") int roomid,
                                                       @Query("start") int start,
                                                       @Query("len") int len);


}
