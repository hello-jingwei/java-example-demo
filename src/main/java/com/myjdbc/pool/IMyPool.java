package com.myjdbc.pool;

import javax.sql.ConnectionPoolDataSource;

public interface IMyPool {
    public MyPoolConnection getMyPoolConnection();

    public void createMyPoolConnection(int count);

}
