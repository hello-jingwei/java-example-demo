package com.reflect.sayhello.entity;

import com.reflect.sayhello.itface.ISayInterface;

public class Hello implements ISayInterface {
    @Override
    public void sayHello(String name){
        System.out.println("hello, " + name);
    }
}
