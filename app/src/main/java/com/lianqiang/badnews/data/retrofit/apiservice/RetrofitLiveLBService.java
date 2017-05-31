package com.lianqiang.badnews.data.retrofit.apiservice;

import com.lianqiang.badnews.module.live.bean.LiveMsg;
import com.lianqiang.badnews.module.live.bean.LiveVideoInfor;
import com.lianqiang.badnews.module.live.bean.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Describe:直播信息,当livetype=1时，获取视频信息接口
 *
 * @author lianqiang on 2017/5/31.
 */

public interface RetrofitLiveLBService {

    /**
     * http://luoboapi.v.163.com/api/user/anony?origin=10
     * 获取用户id
     * @return
     */
    @GET("api/user/anony?origin=10")
    Observable<User> getUserId();

    /**
     * http://luoboapi.v.163.com/api/list/getOneVideo
     * 获取视频信息
     * @param videoId 这个id是房间id
     * @param origin
     * @param type
     * @param userId
     * @return
     */
    @POST("api/list/getOneVideo")
    Observable<LiveVideoInfor> getVideoInfor(
            @Query("videoId") String videoId,
            @Query("origin") int origin,
            @Query("type") int type,
            @Query("userId") String userId
    );

    /**
     * 获取聊天内容
     * @param videoId 这个id是上面接口返回的videoid
     * @param origin
     * @param num
     * @param currpage
     * @return
     */
    @GET("api/list/comment/getMoreComment")
    Observable<LiveMsg> getLiveMsg(
            @Query("videoId") String videoId,
            @Query("origin") int origin,
            @Query("num") int num,
            @Query("currpage") int currpage
    );

}
