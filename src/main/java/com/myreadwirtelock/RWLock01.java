package com.myreadwirtelock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLock01 extends Thread {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];


    public static void main(String[] args) {
        RWLock01 rwLock01 = new RWLock01();
        Thread thread1 = new Thread(rwLock01);
        Thread thread2 = new Thread(rwLock01);
        thread1.start();
        thread2.start();
        new Thread(() -> new RWLock01().doAny(2)).start();
    }


    @Override
    public void run() {
        doAny(1);
    }

    public void doAny(int flag) {
        if (flag == 1) {
            get();
        } else if (flag == 2) {
            inc(0);
        }
    }

    public void inc(int index) {
        wlock.lock(); // 加写锁
        System.out.println(LocalDateTime.now() + "->获取到写锁");
        try {
            counts[index] += 1;
            System.out.println(counts[index]);
        } finally {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wlock.unlock(); // 释放写锁
        }
    }

    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            int[] nArray = Arrays.copyOf(counts, counts.length);
            System.out.println(LocalDateTime.now() + "-" + Thread.currentThread().getName() + "->获取到读锁");
            return nArray;
        } finally {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rlock.unlock(); // 释放读锁
            System.out.println(Thread.currentThread().getName() + "-读锁已释放");
        }
    }
}
