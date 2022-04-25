package com.mymap;

import java.util.HashMap;
import java.util.Map;

/**
 * map.merge()
 * 如果不存在，则将值赋给key；
 * 如果存在，则做响应的更新操作；
 */
public class MyMap03 {


    public static void main(String[] args) {
        Map<String,Integer> map1 = new HashMap<>(4);
        map1.put("a",1);
        map1.put("b",2);
        map1.put("c",3);
        map1.put("d",4);


        Map<String,Integer> map2 = new HashMap<>(4);
        map2.put("e",5);

        Map map3 = new HashMap();
        map3.putAll(map1);
        map3.putAll(map2);

        System.out.println(map3);
    }
}
