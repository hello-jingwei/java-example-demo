package com.myjson;

import com.alibaba.fastjson.JSON;
import com.myjson.entity.User;

public class FastJsonAnnon {

    public static void main(String[] args) {
        User user = new User("1","张三");
        String jsonStr = JSON.toJSONString(user);
        System.out.println(jsonStr);
    }
}
