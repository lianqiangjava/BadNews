package com.lianqiang.badnews.module.live.view;

import com.lianqiang.badnews.base.BaseView;
import com.lianqiang.badnews.module.live.bean.LiveChat;
import com.lianqiang.badnews.module.live.bean.LiveChatTopic;
import com.lianqiang.badnews.module.live.bean.LiveUserCount;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/29.
 */

public interface ILiveRoomView extends BaseView {

    void setLiveInfo(LiveChat liveChat);

    void updateItemChat(LiveChat liveChat);

    void updateUserCount(LiveUserCount liveUserCount);

    void setLiveTopic(LiveChatTopic liveTopic);

}
