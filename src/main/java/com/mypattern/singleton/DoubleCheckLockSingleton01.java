package com.mypattern.singleton;

public class DoubleCheckLockSingleton01 {
    private volatile static DoubleCheckLockSingleton01 instance;

    private DoubleCheckLockSingleton01() {
    }

    public static DoubleCheckLockSingleton01 getInstance() {

        if (instance == null) {

            synchronized (DoubleCheckLockSingleton01.class) {

                if (instance == null) {

                    instance = new DoubleCheckLockSingleton01();

                }

            }

        }

        return instance;

    }


    public static void main(String[] args) {
        DoubleCheckLockSingleton01 d = DoubleCheckLockSingleton01.getInstance();
        System.out.println(d.hashCode());
    }

}
