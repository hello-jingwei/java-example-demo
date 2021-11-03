package com.myjdbc.pool;

import com.myjdbc.pool.impl.MyDefaultPool;

public class MyPoolFactory {
    public static class CreatePool {
        public static IMyPool iMyPool = new MyDefaultPool();
    }

    public static IMyPool getInstance(){
        return CreatePool.iMyPool;
    }
}
