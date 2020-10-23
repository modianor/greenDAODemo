package com.zjgsu.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.zjgsu.greendaodemo.model.DaoMaster;
import com.zjgsu.greendaodemo.model.DaoSession;

/*
 *  项目名:    greenDaoDemo
 *  包名:      com.zjgsu.greendaodemo
 *  文件名:    MyApplication
 *  创建者:    Geely
 *  创建时间:  2020/10/22 20:38
 *  描述:      Desp
 */
public class MyApplication extends Application {

    public static DaoSession mSession;

    @Override
    public void onCreate() {
        super.onCreate();

        initDb();
    }

    /**
     * 连接数据库并创建会话
     */
    public void initDb() {
        // 1、获取需要连接的数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "test.db");
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        // 2、创建数据库连接
        DaoMaster daoMaster = new DaoMaster(db);
        // 3、创建数据库会话
        mSession = daoMaster.newSession();
    }
}
