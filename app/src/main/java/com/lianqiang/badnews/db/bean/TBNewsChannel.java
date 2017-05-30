package com.lianqiang.badnews.db.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Describe: 数据库表:新闻频道
 *
 * @author lianqiang on 2017/5/19.
 */
@DatabaseTable
public class TBNewsChannel implements Serializable{

    private static final long serialVersionUID = 1L;

    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField
    public String channelId;
    @DatabaseField
    public String channelName;
    @DatabaseField
    public String channelType;

    public TBNewsChannel(){

    }

    public TBNewsChannel(String channelId,String channelName,String channelType){
        this.channelId = channelId;
        this.channelName = channelName;
        this.channelType = channelType;
    }


}
