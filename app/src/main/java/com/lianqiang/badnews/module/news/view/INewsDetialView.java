package com.lianqiang.badnews.module.news.view;

import com.lianqiang.badnews.base.BaseView;
import com.lianqiang.badnews.module.news.bean.NewsDetail;

/**
 * Describe: 新闻详情
 *
 * @author lianqiang on 2017/5/22.
 */

public interface INewsDetialView extends BaseView{

    void initDetailData(NewsDetail newsDetail);
}
