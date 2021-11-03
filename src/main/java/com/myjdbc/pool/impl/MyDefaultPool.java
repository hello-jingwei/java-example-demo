package com.myjdbc.pool.impl;

import com.myjdbc.pool.DBConfigXML;
import com.myjdbc.pool.IMyPool;
import com.myjdbc.pool.MyPoolConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Vector;

public class MyDefaultPool implements IMyPool {

    private Vector<MyPoolConnection> myPoolConnections = new Vector<>();
    private static String jdbcDrier;
    private static String jdbcUrl;
    private static String jdbcUserName;
    private static String jdbcPassword;

    private static int initCount;
    private static int step;
    private static int maxCount;

    public MyDefaultPool() {
        init();

        try {
            Class.forName(DBConfigXML.jdbcDrier);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        createMyPoolConnection(initCount);
    }

    private void init() {
        jdbcDrier = DBConfigXML.jdbcDrier;
        jdbcUrl = DBConfigXML.jdbcUrl;
        jdbcUserName = DBConfigXML.jdbcUserName;
        jdbcPassword = DBConfigXML.jdbcPassword;

        initCount = DBConfigXML.initCount;
        step = DBConfigXML.step;
        maxCount = DBConfigXML.maxCount;
    }

    @Override
    public MyPoolConnection getMyPoolConnection() {
        if (myPoolConnections.size() < 1) {
            throw new RuntimeException("连接池初始化错误!");
        }
        MyPoolConnection myPoolConnection = null;
        try {
            myPoolConnection = getRealConnectionFromPool();
            while (Objects.isNull(myPoolConnection)) {
                createMyPoolConnection(step);
                myPoolConnection = getRealConnectionFromPool();
                return myPoolConnection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myPoolConnection;
    }

    private synchronized MyPoolConnection getRealConnectionFromPool() throws SQLException {
        for (MyPoolConnection curConnection:myPoolConnections) {
            if (!curConnection.isBusy()) {
                try {
                    if (curConnection.getConnection().isValid(3000)) ;
                    curConnection.setBusy(true);
                    return curConnection;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                Connection connection = null;
                try {
                    connection = DriverManager.getConnection(DBConfigXML.jdbcUrl, DBConfigXML.jdbcUserName, DBConfigXML.jdbcPassword);
                    curConnection.setBusy(true);
                    return curConnection;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void createMyPoolConnection(int count) {
        if (myPoolConnections.size() > maxCount || (myPoolConnections.size() + count) > maxCount) {
            throw new RuntimeException("连接池已满！");
        }

        for (int i = 0; i < count; i++) {
            try {
                Connection connection = DriverManager.getConnection(DBConfigXML.jdbcUrl, DBConfigXML.jdbcUserName, DBConfigXML.jdbcPassword);
                MyPoolConnection myPoolConnection = new MyPoolConnection(connection,false);
                myPoolConnections.add(myPoolConnection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
