package com.lianqiang.badnews.db.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Describe: 存储用户选择过的频道
 *
 * @author lianqiang on 2017/5/19.
 */

@DatabaseTable
public class TBSelectedChannel implements Serializable{

    private static final long serialVersionUID = 1L;

    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField
    public String channelId;
    @DatabaseField
    public String channelName;
    @DatabaseField
    public String channelType;
    @DatabaseField
    public int statu;//选择状态(0:未选择，1:已选择)

    public TBSelectedChannel(){

    }

    public TBSelectedChannel(String channelId,String channelName,String channelType,int statu){
        this.channelId = channelId;
        this.channelName = channelName;
        this.channelType = channelType;
        this.statu = statu;
    }

}
