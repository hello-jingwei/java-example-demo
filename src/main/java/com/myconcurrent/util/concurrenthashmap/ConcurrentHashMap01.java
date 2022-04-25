package com.myconcurrent.util.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 线程安全的map
 */
public class ConcurrentHashMap01 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            test1();
        }
//        test1();
    }

    /**
     * 使用线程安全的方式递增key为a的值，输入为10
     *
     * await()方法控制的线程，当countDown()不为0时，线程不会释放，一直等待
     *
     * CountDownLatch当countDown()不为0时，会一直等待
     *
     */
    public static void test1() {
        final Map<String, Integer> count = new ConcurrentHashMap<>();
        final CountDownLatch endLatch = new CountDownLatch(2);
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                // 如不存再，更新位给定值
                // 入存在更新现有值给当前key
                count.merge("a", 1, Integer::sum);
            }
            endLatch.countDown();
            System.out.println(count);
        };
        new Thread(task).start();
        new Thread(task).start();

        try {
            System.out.println("child thread is running");
            endLatch.await();
//            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
