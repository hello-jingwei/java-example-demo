package com.mythis;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class Child extends Parent{
    private String name;

}
