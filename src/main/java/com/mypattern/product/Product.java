package com.mypattern.product;

import java.util.ArrayList;

/**
 * 建造者模式
 *
 * step1:构建建造者
 */
public class Product {
    ArrayList<String> parts = new ArrayList<String>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println(parts);
    }
}
