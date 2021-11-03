package com.mythread.threadpool;

import java.util.concurrent.*;

/**
 * java内置线程池创建方式对最大线程数、线程存活时间定义过简单，容易造成出问题
 */
public class MyExecutorService {
    public void buildFixedPool(){
        // 主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(new Echo("******"));
        try {
            System.out.println("echo:" + future.get());
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void buildCachedPool(){
        // 主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new Echo("******"));
        try {
            System.out.println("echo:" + future.get());
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void buildScheduledPool(){
        // 主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM
        ExecutorService executorService = Executors.newScheduledThreadPool(1);
        Future<String> future = executorService.submit(new Echo("******"));
        try {
            System.out.println("echo:" + future.get());
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyExecutorService().buildScheduledPool();
    }
}

class Echo implements Callable<String> {
    private String msg;

    Echo(String msg) {
        this.msg = msg;
    }

    @Override
    public String call() throws Exception {
        return msg;
    }
}