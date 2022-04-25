package com.mypattern.singleton;

/**
 * 利用静态类初次访问时创建对象的机制
 * 实现了一种安全的单例实现方式，避免反射入侵
 */
public class StaticInnerClassSingleton02 {
    private StaticInnerClassSingleton02() {
    }

    public static StaticInnerClassSingleton02 getInstance() {
        return SingleTonInstance.instance;
    }


    private static class SingleTonInstance {
        private static final StaticInnerClassSingleton02 instance = new StaticInnerClassSingleton02();
    }


}
