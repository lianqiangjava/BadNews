package com.lianqiang.badnews.module.news.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.base.BaseActivity;
import com.lianqiang.badnews.module.news.bean.NewsDetail;
import com.lianqiang.badnews.module.news.presenter.NewsDetailPresenter;
import com.lianqiang.badnews.module.news.view.INewsDetialView;
import com.lianqiang.badnews.utils.RichTextUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 新闻详情
 *
 * @author lianqiang on 2017/5/22.
 */

public class NewsDetailActivity extends BaseActivity<NewsDetailPresenter> implements INewsDetialView {

    private static final String TAG = "NewsDetailActivity";

    @BindView(R.id.news_content)
    TextView contentTV;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.news_title)
    TextView newsTitle;
    @BindView(R.id.news_detail_source)
    TextView newsDetailSource;
    @BindView(R.id.news_release_time)
    TextView newsReleaseTime;

    private String postid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        Bundle bundle = getIntent().getExtras();
        postid = bundle.getString("postid");

        if (!TextUtils.isEmpty(postid)) {
            presenter = new NewsDetailPresenter(this, postid);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        newsReleaseTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, "onTouch: " );
                return true;
            }
        });

        newsReleaseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: " );
            }
        });

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: ");
        return super.onTouchEvent(event);

    }

    @Override
    public void initDetailData(NewsDetail data) {
        RichTextUtil.formatHtml(this, contentTV, data);
        newsTitle.setText(data.getTitle());
        newsDetailSource.setText(data.getSource());
        newsReleaseTime.setText(data.getPtime());

    }
}
