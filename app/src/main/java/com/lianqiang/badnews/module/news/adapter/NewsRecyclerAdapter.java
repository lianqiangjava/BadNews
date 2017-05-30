package com.lianqiang.badnews.module.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.module.news.bean.NewsList;
import com.lianqiang.badnews.utils.GlideUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe: 新闻列表适配器
 *
 * @author lianqiang on 2017/5/21.
 */

public class NewsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private static final int VIEW_TYPE_HEAD = 0;//图片轮播视图
    private static final int VIEW_TYPE_IDLE = 1;//左侧图片，右侧标题视图
    private static final int VIEW_TYPE_OTHER = 2;//顶部标题，底部三张图片视图

    private Context context;
    private LayoutInflater inflater;
    private List<NewsList> newsLists;

    private OnRecyclerViewItemClickListener onItemClickListener;

    public NewsRecyclerAdapter(Context context,List<NewsList> newsLists){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.newsLists = newsLists;
    }

    public void setData(List<NewsList> data){
        if(data != null){
            newsLists = data;
            notifyDataSetChanged();
        }
    }

    public void addMoreData(List<NewsList> data) {
        if(data != null){
            int startPos = newsLists.size();
            newsLists.addAll(data);
            notifyItemRangeInserted(startPos, data.size());
        }
    }

    @Override
    public int getItemCount() {
        return newsLists == null ? 0:newsLists.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(newsLists == null){
            return -1;
        }
        if (newsLists.get(position).getHasHead() == 1){
            return VIEW_TYPE_HEAD;
        }else if(newsLists.get(position).getImgextra()!=null && newsLists.get(position).getImgextra().size()>0){
            return VIEW_TYPE_OTHER;
        }else {
            return VIEW_TYPE_IDLE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = null;
        switch (viewType){
            case VIEW_TYPE_HEAD:
                view = inflater.inflate(R.layout.item_news_head_banner,null);
                viewHolder = new HeadViewHolder(view);
                break;
            case VIEW_TYPE_IDLE:
                view = inflater.inflate(R.layout.item_news_idle,null);
                viewHolder = new IdleViewHolder(view);
                break;
            case VIEW_TYPE_OTHER:
                view = inflater.inflate(R.layout.item_news_other,null);
                viewHolder = new OtherViewHolder(view);
                break;
        }

        if(view != null){
            view.setOnClickListener(this);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewsList bean = newsLists.get(position);
        switch (getItemViewType(position)){
            case VIEW_TYPE_HEAD:
                HeadViewHolder headHolder = (HeadViewHolder)holder;
                List<String> imgUrls = new ArrayList<String>();
                List<String> imgtitles = new ArrayList<String>();
                if(bean.getAds() != null && bean.getAds().size()>0){
                    for (NewsList.AdsBean adsBean : bean.getAds()) {
                        imgUrls.add(adsBean.getImgsrc());
                        imgtitles.add(adsBean.getTitle());
                    }
                }else {
                    imgUrls.add(bean.getImgsrc());
                    imgtitles.add(bean.getTitle());
                }

                headHolder.banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
                headHolder.banner.setImages(imgUrls);
                headHolder.banner.setImageLoader(new GlideImageLoader());
                headHolder.banner.setBannerTitles(imgtitles);
                headHolder.banner.start();

                headHolder.itemView.setTag(bean.getPostid());//用于item点击时获取postid
                break;
            case VIEW_TYPE_IDLE:
                IdleViewHolder idleHolder = (IdleViewHolder)holder;
                GlideUtil.getImg(context,bean.getImgsrc(),idleHolder.preview_img);
                idleHolder.news_title.setText(bean.getTitle());
                idleHolder.news_source.setText(bean.getSource());
                idleHolder.news_votecount.setText(bean.getVotecount()+"跟帖");

                idleHolder.itemView.setTag(bean.getPostid());
                break;
            case VIEW_TYPE_OTHER:
                OtherViewHolder otherHolder = (OtherViewHolder)holder;
                otherHolder.news_other_title.setText(bean.getTitle());
                otherHolder.news_other_source.setText(bean.getSource());
                otherHolder.news_other_votecount.setText(bean.getVotecount()+"跟帖");
                GlideUtil.getImg(context,bean.getImgsrc(),otherHolder.news_other_img_one);
                GlideUtil.getImg(context,bean.getImgextra().get(0).getImgsrc(),otherHolder.news_other_img_two);
                GlideUtil.getImg(context,bean.getImgextra().get(1).getImgsrc(),otherHolder.news_other_img_three);

                otherHolder.itemView.setTag(bean.getPostid());
                break;
        }

    }



    class HeadViewHolder extends RecyclerView.ViewHolder{

        Banner banner;

        public HeadViewHolder(View itemView) {
            super(itemView);
            banner = (Banner)itemView.findViewById(R.id.head_banner);

        }
    }

    class IdleViewHolder extends RecyclerView.ViewHolder{

        ImageView preview_img;
        TextView news_title;
        TextView news_source;
        TextView news_votecount;

        public IdleViewHolder(View itemView) {
            super(itemView);
            preview_img = (ImageView)itemView.findViewById(R.id.preview_img);
            news_title = (TextView)itemView.findViewById(R.id.news_title);
            news_source = (TextView)itemView.findViewById(R.id.news_source);
            news_votecount = (TextView)itemView.findViewById(R.id.news_votecount);
        }
    }

    class OtherViewHolder extends RecyclerView.ViewHolder{

        TextView news_other_title,news_other_source,news_other_votecount;
        ImageView news_other_img_one,news_other_img_two,news_other_img_three;

        public OtherViewHolder(View itemView) {
            super(itemView);
            news_other_title = (TextView)itemView.findViewById(R.id.news_other_title);
            news_other_source = (TextView)itemView.findViewById(R.id.news_other_source);
            news_other_votecount = (TextView)itemView.findViewById(R.id.news_other_votecount);
            news_other_img_one = (ImageView)itemView.findViewById(R.id.news_other_img_one);
            news_other_img_two = (ImageView)itemView.findViewById(R.id.news_other_img_two);
            news_other_img_three = (ImageView)itemView.findViewById(R.id.news_other_img_three);

        }
    }

    //图片轮播使用的加载方式
    class GlideImageLoader extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            GlideUtil.getImg(context,path.toString(),imageView);
        }
    }


    public interface OnRecyclerViewItemClickListener{
        void onItemClick(View view,String postid);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener){
        this.onItemClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener != null && v.getTag()!=null){
            onItemClickListener.onItemClick(v,v.getTag().toString());
        }
    }


}
