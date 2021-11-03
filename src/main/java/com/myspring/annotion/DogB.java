package com.myspring.annotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DogB {
    @Dog(name = "ww", color = "yellow")
    public void getDogProp(){
        System.out.println("==============");
    }

    @Autowired
    private Cat cat;

    public DogB(){
        cat = new Cat();
    }
}
