package com.mythis;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@Accessors(fluent = true)
public class Parent implements Serializable {
    Parent parent;
    public Parent(){
        
    }

    public Child child;
}

