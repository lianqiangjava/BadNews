package com.lianqiang.badnews.module.video.view;

import com.lianqiang.badnews.base.BaseView;
import com.lianqiang.badnews.db.bean.TBVideoChannel;

import java.util.List;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/25.
 */

public interface IVideoChannelView extends BaseView{

    void updateAdapter(List<TBVideoChannel> channelList);
}
