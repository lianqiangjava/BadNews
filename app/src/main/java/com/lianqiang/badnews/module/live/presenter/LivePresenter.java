package com.lianqiang.badnews.module.live.presenter;

import com.lianqiang.badnews.base.BasePresenterImpl;
import com.lianqiang.badnews.module.live.bean.LiveVideo;
import com.lianqiang.badnews.data.service.LiveVideoService;
import com.lianqiang.badnews.module.live.view.ILiveView;

/**
 * Describe:直播列表业务
 *
 * @author lianqiang on 2017/5/28.
 */

public class LivePresenter extends BasePresenterImpl<ILiveView,LiveVideo> {

    private int mStartPage = 1;
    private boolean mIsRefresh = true;

    public LivePresenter(ILiveView view) {
        super(view);
    }


    public void refreshData(){
        mStartPage = 1;
        mIsRefresh = true;
        LiveVideoService.getLiveList(mStartPage,this);
    }

    public void loadMore(){
        mIsRefresh = false;
        LiveVideoService.getLiveList(mStartPage,this);
    }

    @Override
    public void onSuccess(LiveVideo data) {
        mView.updateLive(data,mIsRefresh);
        if(data !=null && data.getNextPage() > data.getPageNo()){
            mStartPage = data.getNextPage();
        }
    }


}
