package com.mylist;

import java.util.HashMap;
import java.util.Map;

public class List02 {
    public static void main(String[] args) {
        Map<String,Object> deliveryFormMap = new HashMap<>();
        deliveryFormMap.put("country_id","AS01");
        String countryId = (String)deliveryFormMap.get("country_id");
        System.out.println(new StringBuilder(countryId).append(000000));
    }
}
