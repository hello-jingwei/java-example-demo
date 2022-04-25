package com.test;


import lombok.NonNull;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class CommonTest {
    private static final String regExp = "^select|update|delete|insert|truncate|\\<|\\>|console|script|alert$";


    private static final String PASS_PATH_KEY_WORDS = "^*compare*|reCompare$";

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedEncodingException {
//        User user = new User("123","李明");
//        show(user.getClass());
//        int a = 0;
//        int b = 0;
//        int i = a + b;
//        i = 1+1;
//        System.out.println(i);
//        noNone(null);
        // logic calc
//        System.out.println((1 | 0) ==1 );
        // time test
//        System.out.println(new Date().getTime());
//        System.out.println(System.currentTimeMillis());
//        validIsRequestTimeout(1L);
        // UUID gen
//        System.out.println(UUID.randomUUID().toString().replace("-", ""));
//        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        // assert test
//        String s = null;
//        Assert.notNull(s,"s is null");
//        String className = getClassTest();
//        Class.forName(className);
        // uri format
//        String decStr = "startregion=%E5%AE%89%E5%BE%BD%E7%9C%81%2C%E6%B7%AE%E5%8C%97%E5%B8%82%2C%E7%9B%B8%E5%B1%B1%E5%8C%BA&endregion=%E5%AE%89%E5%BE%BD%E7%9C%81%2C%E6%B7%AE%E5%8C%97%E5%B8%82%2C%E7%9B%B8%E5%B1%B1%E5%8C%BA&startStationName=%E8%B5%B7%E5%A7%8B1&endStationName=%E7%9B%AE%E7%9A%841&vehicleNos=%E9%99%95A12392";
//        System.out.println(URLDecoder.decode(decStr, StandardCharsets.UTF_8.toString()));
//        System.out.println("compare".matches(PASS_PATH_KEY_WORDS));
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = new Integer(127);
        Integer i4 = new Integer(127);
        System.out.println("i1 == i2：" + (i1 == i2));
        System.out.println("i3 == i4：" + (i3 == i4));
    }

    private static void show(Class<?> clazz){
        System.out.println(clazz);
    }

    private static void noNone(@NonNull String str){
        System.out.println(str);
    }


    private static void validIsRequestTimeout(long timestamp){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long s = 0;
        try {
            s = System.currentTimeMillis() - sdf.parse("2021-09-01 17:23:00").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(s/1000);
    }

    private static String getClassTest(){
        try {
            Integer.parseInt(null);
        } catch (Throwable e) {
            System.out.println(e.getClass().getTypeName());
            return e.getClass().getTypeName();
        }
        return null;
    }
}
