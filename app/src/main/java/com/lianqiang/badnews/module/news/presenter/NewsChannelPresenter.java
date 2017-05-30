package com.lianqiang.badnews.module.news.presenter;

import com.lianqiang.badnews.base.BasePresenterImpl;
import com.lianqiang.badnews.data.service.NewsService;
import com.lianqiang.badnews.db.bean.TBNewsChannel;
import com.lianqiang.badnews.module.news.view.INewsChannelView;

import java.util.List;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/19.
 */

public class NewsChannelPresenter extends BasePresenterImpl<INewsChannelView,List<TBNewsChannel>> {

    public NewsChannelPresenter(INewsChannelView view) {
        super(view);

        NewsService.getNewsChannelList(this);
    }

    @Override
    public void onSuccess(List<TBNewsChannel> data) {
        mView.updateAdapter(data);

    }
}
