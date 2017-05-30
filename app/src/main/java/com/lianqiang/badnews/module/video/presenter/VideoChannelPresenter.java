package com.lianqiang.badnews.module.video.presenter;

import com.lianqiang.badnews.base.BasePresenterImpl;
import com.lianqiang.badnews.data.service.NewsService;
import com.lianqiang.badnews.db.bean.TBVideoChannel;
import com.lianqiang.badnews.module.video.view.IVideoChannelView;

import java.util.List;

/**
 * Describe: 视频渠道业务
 *
 * @author lianqiang on 2017/5/25.
 */

public class VideoChannelPresenter extends BasePresenterImpl<IVideoChannelView,List<TBVideoChannel>> {

    public VideoChannelPresenter(IVideoChannelView view) {
        super(view);

        NewsService.getVideoChannel(this);
    }

    @Override
    public void onSuccess(List<TBVideoChannel> data) {
        mView.updateAdapter(data);
    }
}
