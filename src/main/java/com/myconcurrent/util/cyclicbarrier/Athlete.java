package com.myconcurrent.util.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Athlete implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String name;

    public Athlete(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "就位");
        try {
            cyclicBarrier.await();
            Random random =new Random();
            double time = random.nextDouble() + 9;
            System.out.println(name + ": "+ time);
        } catch (Exception e) {
        }
    }
}
