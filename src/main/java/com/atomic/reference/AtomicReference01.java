package com.atomic.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 模拟线上代码测试问题
 */
public class AtomicReference01 {
    public static void main(String[] args) {
        List<Boolean> redisLockStat = new ArrayList<>();
        redisLockStat.add(true);
        redisLockStat.add(false);
        redisLockStat.add(true);
        AtomicReference<Boolean> isExistLock = new AtomicReference<>();
        redisLockStat.forEach(item -> {
            isExistLock.set(item);
        });

        if(!isExistLock.get()) {
            System.out.println("in");
        }
    }
}
