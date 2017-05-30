package com.lianqiang.badnews.utils;

import android.content.Context;
import android.widget.FrameLayout;

import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/26.
 */

public class ViewUtil {

    private static FrameLayout videoFullContainer;//视频全屏播放时的容器视图
    private static ListVideoUtil listVideoUtil;

    public static void setVideoFullContainer(FrameLayout videoFullContainer) {
        ViewUtil.videoFullContainer = videoFullContainer;
    }

    public static FrameLayout getVideoFullContainer() {
        return videoFullContainer;
    }

    public static synchronized ListVideoUtil getListVideoUtil(Context context){
        if(listVideoUtil==null){
            listVideoUtil = new ListVideoUtil(context);
            listVideoUtil.setFullViewContainer(videoFullContainer);
            listVideoUtil.setHideStatusBar(true);
            listVideoUtil.setHideActionBar(true);
        }
        return listVideoUtil;
    }

    public static void releaseVideoUtil(){
        videoFullContainer = null;
        if(listVideoUtil==null){
            listVideoUtil = null;
        }
    }


}
