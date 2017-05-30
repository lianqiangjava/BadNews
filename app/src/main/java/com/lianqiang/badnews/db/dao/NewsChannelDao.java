package com.lianqiang.badnews.db.dao;

import com.lianqiang.badnews.db.bean.TBNewsChannel;


/**
 * Describe: 新闻频道表的CRUD
 *
 * @author lianqiang on 2017/5/19.
 */

public class NewsChannelDao extends BaseDao<TBNewsChannel>{

    public NewsChannelDao(){
        super(TBNewsChannel.class);
    }

}
