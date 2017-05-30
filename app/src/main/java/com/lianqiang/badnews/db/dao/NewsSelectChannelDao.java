package com.lianqiang.badnews.db.dao;


import com.lianqiang.badnews.db.bean.TBSelectedChannel;

/**
 * Describe: 用户已选频道表
 *
 * @author lianqiang on 2017/5/19.
 */

public class NewsSelectChannelDao extends BaseDao<TBSelectedChannel>{

    public NewsSelectChannelDao(){
        super(TBSelectedChannel.class);
    }

}
