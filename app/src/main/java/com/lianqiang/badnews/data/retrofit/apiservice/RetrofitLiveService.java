package com.lianqiang.badnews.data.retrofit.apiservice;

import com.lianqiang.badnews.module.live.bean.LiveChat;
import com.lianqiang.badnews.module.live.bean.LiveUserCount;
import com.lianqiang.badnews.module.live.bean.LiveVideo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Describe: 直播接口
 *
 * @author lianqiang on 2017/5/27.
 */

public interface RetrofitLiveService {

    /**
     * http://data.live.126.net/livechannel/previewlist/1.json
     * 获取直播列表
     * page 第几页
     * @return
     */
    @GET("livechannel/previewlist/{page}.json")
    Observable<LiveVideo> getLiveList(@Path("page") int page);


    /**
     * http://data.live.126.net/liveAll/134215.json
     * 获取当前直播房间所有直播聊天记录(liveType为0时调用)
     * @param roomId
     * @param page
     * @return
     */
    @GET("liveAll/{roomId}/{page}.json")
    Observable<LiveChat> getChatAll(@Path("roomId") String roomId,@Path("page") int page);

    @GET("liveAll/{roomId}.json")
    Observable<LiveChat> getChatAll(@Path("roomId") String roomId);

    /**
     * http://data.live.126.net/live/134266.json
     * 获取当前直播房间实时聊天记录(liveType为0时调用)
     * @param roomId
     * @return
     */
    @GET("live/{roomId}.json")
    Observable<LiveChat> getChat(@Path("roomId") String roomId);

    /**
     * http://data.live.126.net/partake/usercount/134215.json
     * 获取当前直播参与人数(liveType为0时调用)
     * @param roomId
     * @return
     */
    @GET("partake/usercount/{roomId}.json")
    Observable<LiveUserCount> getLiveUserCount(@Path("roomId") String roomId);


}
