package com.lianqiang.badnews.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.lianqiang.badnews.common.MApplication;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/26.
 */

public class ScreenUtil {

    public static int[] getScreen(Activity activity){
        int[] screen = new int[2];
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = activity.getWindowManager();
        manager.getDefaultDisplay().getMetrics(dm);
        screen[0] = dm.widthPixels;
        screen[1] = dm.heightPixels;
        return screen;
    }
}
