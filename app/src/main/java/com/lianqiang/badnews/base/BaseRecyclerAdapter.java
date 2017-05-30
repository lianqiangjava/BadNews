package com.lianqiang.badnews.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/28.
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private int mLayoutId;
    private List<T> mData;

    public BaseRecyclerAdapter(Context context, @LayoutRes int layoutId,List<T> data) {
        mContext = context;
        mLayoutId = layoutId;
        mData = data;
    }

    public void setData(List<T> data){
        mData = data;
        notifyDataSetChanged();
    }

    public void loadMore(List<T> data){
        if(data !=null){
            int startPos = mData.size();
            mData.addAll(data);
            notifyItemRangeInserted(startPos,data.size());
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        BaseViewHolder viewHolder = BaseViewHolder.get(mContext,viewGroup,mLayoutId);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int position) {
        onBind(baseViewHolder,mData.get(position));
    }

    public abstract void onBind(BaseViewHolder viewHolder,T t);

    @Override
    public int getItemCount() {
        return mData !=null ? mData.size() : 0;
    }
}
