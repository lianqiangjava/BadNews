package com.lianqiang.badnews.module.video.view;

import com.lianqiang.badnews.base.BaseView;
import com.lianqiang.badnews.module.video.bean.VideoList;

import java.util.List;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/25.
 */

public interface IVideoListView extends BaseView {
    void updateVideoList(List<VideoList> videoLists,boolean isRefresh);
}
