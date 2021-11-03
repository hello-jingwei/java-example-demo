package com.redis.lock;

import java.util.concurrent.atomic.AtomicReference;

public class NXLockDemo1 {
    public static void main(String[] args) {
        AtomicReference<Boolean> isExistLock = new AtomicReference<>();
        isExistLock.set(tryGetDistributedLock("pay_confirm_delivery:" + "001", "test", 20000));
        Boolean res = isExistLock.get();
        System.out.println(res);
    }

    public static boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {
        RedisTool redisTool = new RedisTool();
        Boolean res = redisTool.tryGetDistributedLock(lockKey, requestId, expireTime);
        return res;
    }
}
