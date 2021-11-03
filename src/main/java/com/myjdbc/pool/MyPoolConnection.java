package com.myjdbc.pool;

import lombok.Data;

import java.sql.*;

@Data
public class MyPoolConnection {
    private Connection connection;
    private boolean isBusy;

    public MyPoolConnection(Connection connection, boolean isBusy) {
        this.connection = connection;
        this.isBusy = isBusy;
    }

    public void close() {
        this.isBusy = false;
    }

    public boolean isBusy(){
        return true;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBConfigXML.jdbcUrl, DBConfigXML.jdbcUserName, DBConfigXML.jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet query(String sql) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
