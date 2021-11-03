package com.mypattern.product;

/**
 * step3:构建builder实现类
 */
public class ConcreteBuilder extends Builder {
    private Product product = new Product();
    public Product getResult() {
        return product;
    }
    @Override
    public void buildPartA() {
        product.add("构建产品的上半部分");
    }

    @Override
    public void buildPartB() {
        product.add("构建产品的下半部分");
    }
}