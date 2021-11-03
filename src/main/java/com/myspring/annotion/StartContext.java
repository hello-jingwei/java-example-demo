package com.myspring.annotion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class StartContext {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DogB.class);
        System.out.println("IOC容器创建完成........");
//        DecimalFormat decimalFormat = new DecimalFormat("#.000");
//        BigDecimal num = new BigDecimal(124);
//        System.out.println(decimalFormat.format(num));
    }
}
