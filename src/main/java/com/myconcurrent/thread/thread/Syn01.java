package com.myconcurrent.thread.thread;

public class Syn01 extends Thread{

    private static A a = new A();

    public static void main(String[] args) {
        Syn01 syn01 = new Syn01();
        new Thread(syn01).start();
        new Thread(syn01).start();
    }

    @Override
    public void run() {
        synTest();
    }

    public int synTest() {
        synchronized (a) {
            System.out.println(Thread.currentThread().getName() + "-syn start");
            System.out.println(10/0);
            System.out.println("syn end");
            return 1;
        }
    }
}

class A{}


