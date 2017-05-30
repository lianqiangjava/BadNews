package com.lianqiang.badnews.module.news.view;

import com.lianqiang.badnews.base.BaseView;
import com.lianqiang.badnews.module.news.bean.NewsList;

import java.util.List;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/18.
 */

public interface INewsListView extends BaseView {

    void updateNewsList(List<NewsList> newsLists,boolean isRefresh);
}
