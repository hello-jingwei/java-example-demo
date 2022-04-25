package com.reflect.example;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * CallerSensitive 有个特殊之处，必须由 启动类classloader加载（如rt.jar ），
 * 才可以被识别。 所以rt.jar下面的注解可以正常使用。开发者自己写的@CallerSensitive
 * 不可以被识别。 但是，可以利用jvm参数 -Xbootclasspath/a: path 假装自己的程序是启动类。
 */
public class Reflect01 {
    public static void main(String[] args) {
        System.out.println(getCallerClazz());
    }

    @CallerSensitive
    public static Class getCallerClazz() {
        return Reflection.getCallerClass();
    }
}
