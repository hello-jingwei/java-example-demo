package com.reflect.framework.service;

import com.reflect.framework.annotation.FrAnnotation;

public class EvtServiceImpl implements EvtService {

    @Override
    public void introduce( String... names) {
        StringBuilder nameString = new StringBuilder();
        for (String name : names) {
            nameString.append(name).append(" ");
        }
        System.out.println(nameString + "is my friend! ");
    }
}
