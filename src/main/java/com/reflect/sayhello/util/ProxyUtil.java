package com.reflect.sayhello.util;

import com.reflect.sayhello.entity.Hello;
import com.reflect.sayhello.itface.ISayInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil implements InvocationHandler {
    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(
                this.delegate.getClass().getClassLoader(), this.delegate
                        .getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.delegate, args);
    }

    public static void main(String[] args) {
        ProxyUtil proxyUtil = new ProxyUtil();
        Hello hello = new Hello();
        ISayInterface hello1  = (ISayInterface) proxyUtil.bind(hello);
        hello1.sayHello("zhang");
    }
}
