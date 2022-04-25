package com.myconcurrent.thread.threadpool;

import java.util.concurrent.*;

public class MyThreadPoolExecutor {
    public void buildFixedPool(){
        // 主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());;
        Future<String> future = executorService.submit(new Echos("******"));
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
        new MyThreadPoolExecutor().buildFixedPool();
    }
}

class Echos implements Callable<String> {
    private String msg;

    Echos(String msg) {
        this.msg = msg;
    }

    @Override
    public String call() throws Exception {
        return msg;
    }
}