package com.mymap;

import java.util.HashMap;
import java.util.Map;

/**
 * map.merge()
 * 如果不存在，则将值赋给key；
 * 如果存在，则做响应的更新操作；
 */
public class MyMap01 {
    public static Map<String,Integer> test(){
        Map<String,Integer> map = new HashMap<>(4);
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.size();
        return map;
    }

    public static void main(String[] args) {
        Map<String,Integer> map = test();
        System.out.println(map.merge("a", 10, Integer::sum));
    }
}
