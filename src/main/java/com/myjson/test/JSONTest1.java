package com.myjson.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JSONTest1 {
    public static void main(String[] args) {
//        String jsonString = "{\"success\":false,\"code\":3005,\"msg\":\"字段校验失败\",\"data\":[\"异常描述：不能为空，字段：root.header.token，值：null\"]}";
//        JSONObject jsonObject= JSON.parseObject(jsonString);
//        jsonObject.get("data");
        int i  = 1;
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(i);
        System.out.println(list.size());
        Set<Integer> set = new HashSet<>(list);
        System.out.println(set.size());
    }
}
