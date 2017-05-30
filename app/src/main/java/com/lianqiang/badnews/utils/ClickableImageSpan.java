package com.lianqiang.badnews.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;

/**
 * Describe: 自定义可点击的ImageSapn
 *
 * @author lianqiang on 2017/5/22.
 */

public abstract class ClickableImageSpan extends ImageSpan{


    public ClickableImageSpan(Context context, Bitmap b) {
        super(context, b);
    }

    public abstract void onClick(View view);

}
