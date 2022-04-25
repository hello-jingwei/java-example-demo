package com.mytread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TpTest01 {
    private final Object lock = new Object();
    private volatile Integer i = 2;

    public static void main(String[] args) {
//        new TpTest01().test();
        List<String> listA = new ArrayList<>();
        listA.add("a");
        List<String> listB = listA;
        for (String s : listB) {
            System.out.println(s);
        }

    }

    public void test() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 10, 3000,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        while (true) {
            if (i == 0) {
                System.out.println("break");
                break;
            }
//            try {
            pool.execute(new TimerTask() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    if (i == 0) {
                        System.out.println("shutdown");
                        pool.shutdown();
                    }
                    i--;
                }
            });
//            } catch (RejectedExecutionException e) {
//                System.out.println("核心线程已满，拒绝新任务");
//                System.out.println("开始队列任务");
//
//            }


        }


    }
}
