package com.lianqiang.badnews.module.video.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.module.video.bean.VideoList;
import com.lianqiang.badnews.utils.GlideUtil;
import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

import java.util.List;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/25.
 */

public class VideoRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TAG = "VideoRecyclerAdapter";

    private Context context;
    private LayoutInflater inflater;
    private List<VideoList> videoLists;
    private ListVideoUtil videoUtil;

    public VideoRecyclerAdapter(Context context, List<VideoList> videoLists,ListVideoUtil videoUtil){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.videoLists = videoLists;
        this.videoUtil = videoUtil;
    }

    public void setData(List<VideoList> data){
        if(data != null){
            videoLists = data;
            notifyDataSetChanged();
        }
    }

    public void addMoreData(List<VideoList> data) {
        if(data != null){
            int startPos = videoLists.size();
            videoLists.addAll(data);
            notifyItemRangeInserted(startPos, data.size());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_video,null);
        VideoHolder viewHolder = new VideoHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        VideoHolder videoHolder = (VideoHolder)viewHolder;
        videoHolder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        GlideUtil.getImg(context,videoLists.get(position).getCover(),videoHolder.imageView);
        videoHolder.video_title.setText(videoLists.get(position).getTitle());
        videoHolder.video_source.setText(videoLists.get(position).getVideosource());
        videoHolder.video_replyCount.setText(videoLists.get(position).getReplyCount()+"播放");
        GlideUtil.getImg(context,videoLists.get(position).getTopicImg(),videoHolder.video_source_icon);
        videoUtil.addVideoPlayer(position,videoHolder.imageView,TAG,videoHolder.listItemContainer,videoHolder.listItemBtn);
        videoHolder.listItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                videoUtil.setPlayPositionAndTag(position,TAG);
                videoUtil.startPlay(videoLists.get(position).getMp4_url());

            }
        });


    }

    class VideoHolder extends RecyclerView.ViewHolder{

        FrameLayout listItemContainer;
        ImageView listItemBtn;
        ImageView imageView;
        TextView video_title;
        ImageView video_source_icon;
        TextView video_source;
        TextView video_replyCount;


        public VideoHolder(View itemView) {
            super(itemView);
            listItemContainer = (FrameLayout)itemView.findViewById(R.id.list_item_container);
            listItemBtn = (ImageView)itemView.findViewById(R.id.list_item_btn);
            imageView = new ImageView(context);
            video_title = (TextView)itemView.findViewById(R.id.video_title);
            video_source_icon = (ImageView)itemView.findViewById(R.id.video_source_icon);
            video_source = (TextView)itemView.findViewById(R.id.video_source);
            video_replyCount = (TextView)itemView.findViewById(R.id.video_replyCount);
        }
    }

    @Override
    public int getItemCount() {
        return videoLists == null ? 0 : videoLists.size();
    }

}
