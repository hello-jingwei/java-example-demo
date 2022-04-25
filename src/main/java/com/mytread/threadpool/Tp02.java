package com.mytread.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Tp02 {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("线程池-%d").build();
        ExecutorService ex = new ThreadPoolExecutor(2, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(50), namedThreadFactory);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            ex.execute(() -> {
                System.out.println("线程组：" + Thread.currentThread().getThreadGroup() + "   线程池：" + Thread.currentThread().getName() + "  count：" + (finalI +1));
            });
        }
    }
}
