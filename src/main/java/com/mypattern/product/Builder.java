package com.mypattern.product;

/**
 * step2:构建builder抽象类
 */
public abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product getResult() ;
}
