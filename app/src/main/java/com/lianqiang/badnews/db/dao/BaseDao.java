package com.lianqiang.badnews.db.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.lianqiang.badnews.db.DBHelper;
import com.lianqiang.badnews.db.bean.TBNewsChannel;

import java.sql.SQLException;
import java.util.List;

/**
 * Describe: 基类数据表操作
 *
 * @author lianqiang on 2017/5/19.
 */

public class BaseDao<T> {

    private Dao<T,Integer> dao;
    private DBHelper dbHelper;

    protected BaseDao(Class clazz){
        try {
            dbHelper = DBHelper.getHelper();
            dao = dbHelper.getDao(clazz);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 添加
     * @param t
     */
    public void add(T t){
        try {
            dao.create(t);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 更新
     * @param t
     */
    public void update(T t){
        try {
            dao.update(t);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 删除
     * @param t
     */
    public void delete(T t){
        try {
            dao.delete(t);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 查询所有
     * @return
     */
    public List<T> queryForAll(){
        List<T> list = null;
        try {
            list = dao.queryForAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
