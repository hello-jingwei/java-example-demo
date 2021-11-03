package com.redis.redlock;

/**
 * 集群场景下的redis分布式锁
 */
public interface RedLockService {
    /**
     * 获取锁
     * @return 锁key
     */
    String acquire();

    /**
     * 释放锁
     * @return 释放结果
     */
    boolean release();


}
