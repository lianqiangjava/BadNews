package com.lianqiang.badnews.module.news.view;

import com.lianqiang.badnews.base.BaseView;
import com.lianqiang.badnews.db.bean.TBNewsChannel;

import java.util.List;

/**
 * Describe: 新闻渠道
 *
 * @author lianqiang on 2017/5/19.
 */

public interface INewsChannelView extends BaseView {
    void updateAdapter(List<TBNewsChannel> chanelList);
}
