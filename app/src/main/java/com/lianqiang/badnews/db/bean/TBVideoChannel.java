package com.lianqiang.badnews.db.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Describe: 数据表：视频频道
 *
 * @author lianqiang on 2017/5/25.
 */
@DatabaseTable
public class TBVideoChannel implements Serializable {
    private static final long serialVersionUID = 1L;
    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField
    public String channelId;
    @DatabaseField
    public String channelName;

    public TBVideoChannel(){}

    public TBVideoChannel(String channelId,String channelName){
        this.channelId = channelId;
        this.channelName = channelName;
    }
}
