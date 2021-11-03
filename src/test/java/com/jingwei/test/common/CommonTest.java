package com.jingwei.test.common;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class CommonTest {

    /**
     * 随机生成某个范围内的数据
     */
    @Test
    public void test1() {
        Random random = new Random();
        // 保留两位小数
        NumberFormat numberFormat = new DecimalFormat("#.##");
        for (int i = 0; i < 50; i++) {
            System.out.println(numberFormat.format(random.nextFloat() * 2 + 35));
        }
    }

    @Test
    public void test2() {
        BigDecimal g = new BigDecimal("25.98");
        System.out.println(Optional.ofNullable(g));
        Optional.ofNullable(g).ifPresent(a-> {
            System.out.println("a = " + a);
        });
    }

    @Test
    public void test3(){
        System.out.println(new Date().getTime());
    }
}
