package com.jvm.stackoverflow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A {
    public static void main(String[] args) {
        testNativeMethodOutOfMemory();
    }

    public static void testNativeMethodOutOfMemory(){
        int j = 0;
        while(true){
            System.out.println(j++);
            ExecutorService executors = Executors.newFixedThreadPool(50);
            int i=0;
            while(i++<10){
                executors.submit(new Runnable() {
                    public void run() {
                    }
                });
            }
        }
    }
}
