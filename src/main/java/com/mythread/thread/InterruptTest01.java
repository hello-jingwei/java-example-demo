package com.mythread.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InterruptTest01 extends Thread{

    public static void main(String[] args) {
        new Thread(new InterruptTest01()).start();
    }

    @Override
    public void run() {
        test();
    }

    public void test(){
//        System.out.println("========before interrupt========");
//        Thread.currentThread().interrupt();
//        System.out.println("========after interrupt========");
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            blockingQueue.add("李四" + (10-i));
        }
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(blockingQueue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
