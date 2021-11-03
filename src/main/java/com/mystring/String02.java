package com.mystring;

import java.util.Objects;
import java.util.UUID;

/**
 * @author wjw
 */
public class String02 {


    public static void main(String[] args) {
//        System.out.println(null == new A().getA());
//        A a = new A();
//        System.out.println(Objects.nonNull(a));
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }
}

class A{
    private String a = "a";

    public String getA() {
        return a;
    }
}
