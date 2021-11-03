package com.basic.streamat;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream01 {
    public static void main(String[] args) {
        // 获取首字符
        Optional firstArrEl = Arrays.stream(newArr()).findFirst();
        System.out.println(firstArrEl.get());
        // foreach遍历
        Stream<String> stringStream = Arrays.stream(newArr());
        stringStream.forEach(item -> {
            System.out.println(item);
        });
        // filter
        List<String> stringList = Arrays.stream(newArr()).filter(el -> el.equals("c")).collect(Collectors.toList());
        System.out.println(stringList);
        // map
        // <R, A> R：返回结果类型；A：Lambda表达式后面获取的类型，此处为 el.equals，即布尔型
        List<Boolean> mapCollection = Arrays.stream(newArr()).map(el -> el.equals("d")).collect(Collectors.toList());
        System.out.println(mapCollection);
    }

    public static String[] newArr() {
        String[] str = new String[5];
        str[0] = "a";
        str[1] = "b";
        str[2] = "c";
        str[3] = "d";
        str[4] = "e";
        return str;
    }
}
