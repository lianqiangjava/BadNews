package com.lianqiang.badnews.data.service;

import android.util.Log;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.base.BaseSchedulerTransformer;
import com.lianqiang.badnews.module.news.bean.NewsDetail;
import com.lianqiang.badnews.module.news.bean.NewsList;
import com.lianqiang.badnews.module.video.bean.VideoList;
import com.lianqiang.badnews.callback.RequestCallback;
import com.lianqiang.badnews.data.Api;
import com.lianqiang.badnews.data.ResultObserver;
import com.lianqiang.badnews.data.retrofit.apiservice.RetrofitNewsService;
import com.lianqiang.badnews.data.retrofit.manager.RetrofitManager;
import com.lianqiang.badnews.db.bean.TBNewsChannel;
import com.lianqiang.badnews.db.bean.TBVideoChannel;
import com.lianqiang.badnews.db.dao.BaseDao;
import com.lianqiang.badnews.db.dao.NewsChannelDao;
import com.lianqiang.badnews.common.MApplication;
import com.lianqiang.badnews.db.dao.VideoChannelDao;
import com.lianqiang.badnews.utils.SPConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * TODO　
 * Created by lianqiang on 2017/5/17.
 */

public class NewsService {

    private static RetrofitNewsService service = RetrofitManager.buildService(RetrofitNewsService.class);

    /**
     * 获取新闻列表
     * @param type
     * @param id
     * @param startPage
     * @param callback
     */
    public static void getNewsList(String type,final String id,int startPage,RequestCallback callback){
        service.getNewsList(type,id,startPage)
                .compose(new BaseSchedulerTransformer<Map<String, List<NewsList>>>())
                .map(new Function<Map<String,List<NewsList>>, List<NewsList>>() {

                    @Override
                    public List<NewsList> apply(@NonNull Map<String, List<NewsList>> stringListMap) throws Exception {
                        List<NewsList> newsList = null;
                        for (Map.Entry<String, List<NewsList>> stringListEntry : stringListMap.entrySet()) {
                            newsList = stringListEntry.getValue();
                            break;
                        }
                        return newsList;
                    }
                })
                .subscribe(new ResultObserver<>(callback));
    }

    /**
     * 获得新闻渠道列表
     * @param callback
     */
    public static void getNewsChannelList(RequestCallback callback){
       Observable.create(new ObservableOnSubscribe<List<TBNewsChannel>>() {

           @Override
           public void subscribe(@NonNull ObservableEmitter<List<TBNewsChannel>> e) throws Exception {
               BaseDao dao = new NewsChannelDao();
               //判断是否初始化过新闻渠道数据表
               if(!SPConfig.readBoolean("initNChannel")){

                   Log.i("NewsService", "subscribe: initNChannel");

                   List<String> channelName = Arrays.asList(MApplication.getContext().getResources()
                           .getStringArray(R.array.news_channel));
                   List<String> channelID = Arrays.asList(MApplication.getContext().getResources()
                           .getStringArray(R.array.news_channel_id));

                   for (int i = 0; i < channelName.size(); i++) {
                       TBNewsChannel channel = new TBNewsChannel(channelID.get(i),channelName.get(i),
                               Api.getType(channelID.get(i)));
                       dao.add(channel);
                   }
                   SPConfig.writeBoolean("initNChannel",true);
               }

               List<TBNewsChannel> channelList = dao.queryForAll();
               e.onNext(channelList);
               e.onComplete();

           }
       }).compose(new BaseSchedulerTransformer<>())
               .subscribe(new ResultObserver<>(callback));
    }

    /**
     * 获取新闻详情
     * @param postid 新闻id
     * @param callback
     */
    public static void getNewsDetail(String postid,RequestCallback callback){
        service.getNewsDetail(postid)
                .compose(new BaseSchedulerTransformer<Map<String, NewsDetail>>())
                .map(new Function<Map<String,NewsDetail>, NewsDetail>() {

                    @Override
                    public NewsDetail apply(@NonNull Map<String, NewsDetail> stringNewsDetailMap) throws Exception {
                        NewsDetail newsDetail = null;
                        for (Map.Entry<String, NewsDetail> stringNewsDetailEntry : stringNewsDetailMap.entrySet()) {
                            newsDetail = stringNewsDetailEntry.getValue();
                        }
                        return newsDetail;
                    }
                }).subscribe(new ResultObserver<>(callback));
    }

    /**
     * 获取视频渠道
     * @param callback
     */
    public static void getVideoChannel(RequestCallback callback){
        Observable.create(new ObservableOnSubscribe<List<TBVideoChannel>>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<List<TBVideoChannel>> e) throws Exception {
                BaseDao dao = new VideoChannelDao();
                //判断是否初始化过视频渠道数据表
                if(!SPConfig.readBoolean("initVChannel")){

                    Log.i("NewsService", "subscribe: initVChannel");

                    List<String> channelName = Arrays.asList(MApplication.getContext().getResources()
                            .getStringArray(R.array.video_channel));
                    List<String> channelID = Arrays.asList(MApplication.getContext().getResources()
                            .getStringArray(R.array.video_channel_id));

                    for (int i = 0; i < channelName.size(); i++) {
                        TBVideoChannel channel = new TBVideoChannel(channelID.get(i),channelName.get(i));
                        dao.add(channel);
                    }
                    SPConfig.writeBoolean("initVChannel",true);
                }

                List<TBVideoChannel> channelList = dao.queryForAll();
                e.onNext(channelList);
                e.onComplete();

            }
        }).compose(new BaseSchedulerTransformer<>())
                .subscribe(new ResultObserver<>(callback));
    }

    /**
     * 获取视频列表
     * @param videoId
     * @param startPage
     * @param callback
     */
    public static void getVideoList(String videoId,int startPage,RequestCallback callback){
        service.getVideoList(videoId,startPage)
                .compose(new BaseSchedulerTransformer<Map<String, List<VideoList>>>())
                .map(new Function<Map<String,List<VideoList>>, List<VideoList>>() {
                    @Override
                    public List<VideoList> apply(Map<String, List<VideoList>> stringListMap) throws Exception {
                        List<VideoList> videoLists = null;
                        for (Map.Entry<String, List<VideoList>> stringListEntry : stringListMap.entrySet()) {
                            videoLists = stringListEntry.getValue();
                            break;
                        }
                        return videoLists;
                    }
                }).subscribe(new ResultObserver<>(callback));
    }


}
