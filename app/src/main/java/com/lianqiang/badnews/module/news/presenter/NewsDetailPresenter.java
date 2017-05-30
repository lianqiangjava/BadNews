package com.lianqiang.badnews.module.news.presenter;

import com.lianqiang.badnews.base.BasePresenterImpl;
import com.lianqiang.badnews.module.news.bean.NewsDetail;
import com.lianqiang.badnews.data.service.NewsService;
import com.lianqiang.badnews.module.news.view.INewsDetialView;

/**
 * Describe: 新闻详情业务
 *
 * @author lianqiang on 2017/5/22.
 */

public class NewsDetailPresenter extends BasePresenterImpl<INewsDetialView,NewsDetail> {


    public NewsDetailPresenter(INewsDetialView view,String postid) {
        super(view);
        NewsService.getNewsDetail(postid,this);
    }

    @Override
    public void onSuccess(NewsDetail data) {
        super.onSuccess(data);
        if(data != null){
            mView.initDetailData(data);
        }
    }
}
