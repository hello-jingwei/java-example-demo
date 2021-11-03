package com.stream;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Stream01 {
    public static void main(String[] args) {
        Stream01 s = new Stream01();
        s.test();
    }


    public void test(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        Long filtered = strings.stream().filter(StringUtils::isBlank).count();
        System.out.println(filtered);
    }
}
