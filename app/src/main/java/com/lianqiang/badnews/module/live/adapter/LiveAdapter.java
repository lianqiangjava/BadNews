package com.lianqiang.badnews.module.live.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.module.live.bean.LiveVideo;

import java.util.List;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/28.
 */

public class LiveAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<LiveVideo.LiveReviewBean> mData;
    private LayoutInflater inflater;

    public LiveAdapter(Context context,List<LiveVideo.LiveReviewBean> data){
        mContext = context;
        mData = data;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<LiveVideo.LiveReviewBean> data){
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_live_list,null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder holder = (MyViewHolder)viewHolder;
        holder.tv.setText("555");
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.live_list_count);
        }
    }
}
