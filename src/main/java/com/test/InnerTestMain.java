package com.test;

public class InnerTestMain {
    public static void main(String[] args) {
        InnerClassTest.InnerCls innerCls1 = new InnerClassTest.InnerCls();
        innerCls1.setPropA("a");
        InnerClassTest.InnerCls innerCls2 = new InnerClassTest.InnerCls();
        innerCls2.setPropA("b");

        System.out.println(innerCls1.getPropA());
        System.out.println(innerCls2.getPropA());


    }
}
