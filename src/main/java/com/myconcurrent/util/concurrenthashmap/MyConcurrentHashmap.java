package com.myconcurrent.util.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashmap {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("a",1);
        concurrentHashMap.put("b",1);
        concurrentHashMap.forEach((key, val) -> {
            System.out.println(key + "," + val);
        });
    }
}
