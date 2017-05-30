package com.lianqiang.badnews.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.lianqiang.badnews.R;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/22.
 */

public class GlideUtil {

    /**
     * Glide获取图片返回
     * @param context
     * @param url
     */
    public static void getImg(Context context, String url,ImageView img){
        Glide.with(context).load(url)
                .placeholder(R.drawable.default_img)
                .error(R.drawable.default_img)
                .centerCrop()
                .crossFade()
                .into(img);
    }




}
