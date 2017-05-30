package com.lianqiang.badnews.module.live.view;

import com.lianqiang.badnews.base.BaseView;
import com.lianqiang.badnews.module.live.bean.LiveVideo;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/28.
 */

public interface ILiveView extends BaseView{
    void updateLive(LiveVideo liveVideo,boolean isRefresh);
}
