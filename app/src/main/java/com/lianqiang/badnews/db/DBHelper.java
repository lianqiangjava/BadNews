package com.lianqiang.badnews.db;

import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.lianqiang.badnews.common.Constant;
import com.lianqiang.badnews.db.bean.TBNewsChannel;
import com.lianqiang.badnews.common.MApplication;
import com.lianqiang.badnews.db.bean.TBSelectedChannel;
import com.lianqiang.badnews.db.bean.TBVideoChannel;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Describe: 数据库帮助类
 *
 * @author lianqiang on 2017/5/19.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {

    //数据库名字
    private static final String DB_NAME = Constant.APP_NAME + ".db";
    //数据库版本
    private static final int DB_VERSION = 1;
    //存放Dao
    private Map<String,Dao> daos = new HashMap<String,Dao>();

    private static DBHelper instance;

    /**
     * 获得DBHelper单例
     * @return
     */
    public static synchronized DBHelper getHelper(){
        if (instance == null){
            synchronized (DBHelper.class){
                if(instance == null){
                    instance = new DBHelper();
                    instance.getWritableDatabase();
                }
            }
        }
        return instance;
    }

    public DBHelper(){
        super(MApplication.getContext(),DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        //创建表
        try {
            TableUtils.createTable(connectionSource, TBNewsChannel.class);
            TableUtils.createTable(connectionSource, TBSelectedChannel.class);
            TableUtils.createTable(connectionSource, TBVideoChannel.class);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    /**
     * 更新表
     * @param sqLiteDatabase
     * @param connectionSource
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

        try {
            TableUtils.dropTable(connectionSource,TBNewsChannel.class,true);
            TableUtils.dropTable(connectionSource,TBSelectedChannel.class,true);
            TableUtils.dropTable(connectionSource,TBVideoChannel.class,true);
            onCreate(sqLiteDatabase,connectionSource);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 通过类获得指定Dao
     */
    public Dao getDao(Class clazz) throws SQLException{
        Dao dao = null;
        String className = clazz.getSimpleName();

        if(daos.containsKey(className)){
            dao = super.getDao(clazz);
        }
        if(dao == null){
            dao = super.getDao(clazz);
            daos.put(className,dao);
        }
        return dao;
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
    }
}
