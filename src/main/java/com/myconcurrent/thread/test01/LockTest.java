package com.myconcurrent.thread.test01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest extends Thread {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(lockTest).start();
        new Thread(lockTest).start();
        new Thread(lockTest).start();
//        new Thread(lockTest).start();
//        new Thread(lockTest).start();
//        new Thread(lockTest).start();
//        new Thread(lockTest).start();
//        new Thread(lockTest).start();
    }

    @Override
    public void run() {
        List<String> deliveryIDList = new ArrayList();
        deliveryIDList.add("C1EC104F40134FAEB843F793205FDF14");
        RedisTool redisTool = RedisTool.getInstance();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            List<String> deliveryIds = new ArrayList<>();
            for (String deliveryId : deliveryIDList) {
                boolean lockStat = redisTool.tryGetDistributedLock("pay_confirm_delivery:" + deliveryId, "NET_FREIGHT2_SHIPPER_CONFIRM_PAY_VALUE", 30000);
                System.out.println(Thread.currentThread().getName() + "-lock res: " + lockStat);
                if (Boolean.FALSE.equals(lockStat)) {
                    break;
                } else {
                    deliveryIds.add(deliveryId);
                }
            }
            // 只要存在被加锁运单，释放其他未操作的运单的锁状态
            if (!deliveryIDList.containsAll(deliveryIds)) {
                System.out.println(deliveryIds);
                for (String deliveryId : deliveryIds) {
                    redisTool.releaseDistributedLock("pay_confirm_delivery:" + deliveryId, "NET_FREIGHT2_SHIPPER_CONFIRM_PAY_VALUE");
                }
                System.out.println("请确认是否在其他终端操作同一个运单！");
            }
        } finally {
            lock.unlock();
        }



//        System.out.println(lock);
//        try {
//            System.out.println("lock--" + lock.hashCode());
//            lock.lock();
//            return;
//        } finally {
//            System.out.println("unlock--" + lock.hashCode());
//            lock.unlock();
//        }
    }

}
