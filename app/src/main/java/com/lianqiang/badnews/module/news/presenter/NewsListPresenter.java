package com.lianqiang.badnews.module.news.presenter;

import com.lianqiang.badnews.base.BasePresenterImpl;
import com.lianqiang.badnews.module.news.bean.NewsList;
import com.lianqiang.badnews.data.service.NewsService;
import com.lianqiang.badnews.module.news.view.INewsListView;

import java.util.List;


/**
 * Describe: 获取新闻列表数据并更新View
 *
 * @author lianqiang on 2017/5/18.
 */

public class NewsListPresenter extends BasePresenterImpl<INewsListView,List<NewsList>> {

    private String mNewsType;
    private String mNewsId;
    private int mStartPage;
    private boolean mIsRefresh = true;

    public NewsListPresenter(INewsListView view, String mNewsType, String mNewsId){
        super(view);
        this.mNewsType = mNewsType;
        this.mNewsId = mNewsId;

    }


    @Override
    public void onSuccess(List<NewsList> data) {
        super.onSuccess(data);
        if(data != null){
            mStartPage +=20;
        }
        mView.updateNewsList(data,mIsRefresh);
    }

    public void refreshData(){
        mStartPage = 0;
        mIsRefresh = true;
        NewsService.getNewsList(mNewsType,mNewsId,mStartPage,this);
    }

    public void loadMore(){
        mIsRefresh = false;
        NewsService.getNewsList(mNewsType,mNewsId,mStartPage,this);
    }
}
