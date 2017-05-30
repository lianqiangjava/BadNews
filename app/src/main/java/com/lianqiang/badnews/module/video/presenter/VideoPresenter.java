package com.lianqiang.badnews.module.video.presenter;

import com.lianqiang.badnews.base.BasePresenterImpl;
import com.lianqiang.badnews.module.video.bean.VideoList;
import com.lianqiang.badnews.data.service.NewsService;
import com.lianqiang.badnews.module.video.view.IVideoListView;

import java.util.List;

/**
 * Describe: 视频列表业务
 *
 * @author lianqiang on 2017/5/25.
 */

public class VideoPresenter extends BasePresenterImpl<IVideoListView,List<VideoList>> {

    private String mVideoId;
    private int mStartPage;
    private boolean mIsRefresh = true;

    public VideoPresenter(IVideoListView view, String mVideoId) {
        super(view);
        this.mVideoId = mVideoId;
    }

    @Override
    public void onSuccess(List<VideoList> data) {
        super.onSuccess(data);
        if(data != null){
            mStartPage +=20;
        }
        mView.updateVideoList(data,mIsRefresh);
    }

    @Override
    public void onError(String msg) {
        mView.onError(msg);
    }

    public void refreshData(){
        mStartPage = 0;
        mIsRefresh = true;
        NewsService.getVideoList(mVideoId,mStartPage,this);
    }
    public void loadMore(){
        mIsRefresh = false;
        NewsService.getVideoList(mVideoId,mStartPage,this);
    }
}
