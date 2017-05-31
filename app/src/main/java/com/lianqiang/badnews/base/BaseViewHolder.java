package com.lianqiang.badnews.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lianqiang.badnews.R;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/28.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mItemView;
    private Context mContext;

    private TextView tv;

    public BaseViewHolder(Context context,View itemView) {
        super(itemView);
        mContext = context;
        mItemView = itemView;
        mViews = new SparseArray<>();
        tv = (TextView) itemView.findViewById(R.id.live_list_status);
    }

    public static BaseViewHolder get(Context context, ViewGroup parent,int layoutId){
        View itemView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        BaseViewHolder viewHolder = new BaseViewHolder(context,itemView);
        return viewHolder;
    }

    public View getItemView(){
        return mItemView;
    }

    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view == null){
            view = mItemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T)view;
    }

    public BaseViewHolder setText(int viewId,String text){
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

}
