package com.lianqiang.badnews.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/23.
 */

public class ScaleImageView extends AppCompatImageView implements ScaleGestureDetector.OnScaleGestureListener,
        View.OnTouchListener,ViewTreeObserver.OnGlobalLayoutListener
{
    private static final String TAG = "ScaleImageView";
    public static final float SCALE_MAX = 4.0f;
    private float initScale = 1.0f;
    private final float[] matrixValues = new float[9];
    private boolean once = true;
    private ScaleGestureDetector mScaleGestureDetector = null;
    private final Matrix mScaleMatrix = new Matrix();


    public ScaleImageView(Context context) {
        this(context,null);
    }

    public ScaleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        return false;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return false;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onGlobalLayout() {

    }
}
