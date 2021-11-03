package com.redis.redlock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * redis集群分布式锁实现类
 */
public class RedLockServiceImpl implements RedLockService {

    /**
     * 分布式redis锁客户端，redis官网提供
     */
    private RedissonClient redissonClient;

    /**
     * 锁key
     */
    private String lockKey;

    /**
     * 锁value
     */
    private RLock redLock;

    /**
     * 锁过期时间
     */
    private int expireTime = 10 * 1000;

    /**
     * 获取锁的超时时间
     */
    int acquireTimeout = 500;

    public void init(RedissonClient redissonClient){
        this.redissonClient = redissonClient;
    }

    public void setLockKey(String lockKey){
        this.lockKey = lockKey;
    }

    @Override
    public String acquire() {
            redLock = redissonClient.getLock(lockKey);
            boolean isLock;
            try {
                isLock = redLock.tryLock(acquireTimeout, expireTime, TimeUnit.MILLISECONDS);
                if (isLock) {
                    System.out.println(Thread.currentThread().getName() + " " + lockKey + "获得了锁");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        return null;
    }

    @Override
    public boolean release() {
        if (Objects.nonNull(redLock)) {
            redLock.unlock();
            return true;
        }

        return false;
    }
}
