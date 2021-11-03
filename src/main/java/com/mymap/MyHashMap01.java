package com.mymap;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap01 {
    public void test(){
        Map<String,Object> map = new HashMap<>(4);
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.size();
    }
}
