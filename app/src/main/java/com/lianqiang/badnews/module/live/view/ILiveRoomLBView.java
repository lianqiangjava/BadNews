package com.lianqiang.badnews.module.live.view;

import com.lianqiang.badnews.base.BaseView;
import com.lianqiang.badnews.module.live.bean.LiveMsg;
import com.lianqiang.badnews.module.live.bean.LiveVideoInfor;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/31.
 */

public interface ILiveRoomLBView extends BaseView{

    void setVideoInfor(LiveVideoInfor videoInfor);

    void setVidoChat(LiveMsg liveMsg,boolean isRefresh);
}
