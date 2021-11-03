package com.myredisson.base;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class RedissonClientTest {

    public static void main(String[] args) throws IOException {
        RedissonClient redissonClient = new RedissonClientTest().conn();
        RLock rLock  = redissonClient.getLock("O" + 1);
        System.out.println("==========获取锁===========");
//        System.out.println(rLock.toString());
        try {
            // 尝试加锁，如果锁不存在加锁，如果存在继续后续代码
//            rLock.tryLock(最多等待100s,10s后锁自动释放, TimeUnit.SECONDS);
            rLock.tryLock(100,10, TimeUnit.SECONDS);
            System.out.println(LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("=============业务处理=============");
        } finally {
//            rLock.unlock();
            System.out.println("解锁成功！");
        }

    }

    public RedissonClient conn() throws IOException {
        Config config = new Config();
        config.useSingleServer().setAddress("http://127.0.0.1:6379").setPassword("redis-go").setDatabase(4);
        RedissonClient redissonClient = Redisson.create(config);
        System.out.println(redissonClient.getConfig().toJSON());
        return redissonClient;
    }
}
