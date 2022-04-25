package com.algorithm.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class At01 {
    public static void main(String[] args) {
//        Random random = new Random();
//        divideFee(random);
        decimalTest();

    }

    /**
     * 分割费用
     */
    public static void divideFee(Random random) {
        for (int i = 0; i < 50; i++) {
            DecimalFormat format = new DecimalFormat(".##");
            // 原始值
            BigDecimal dcmNumber = new BigDecimal(format.format(random.nextFloat() * 100 + 30));
            // 平均次数
            int divideCount = random.nextInt(30) + 1;
            // 平均值
            BigDecimal average = dcmNumber.divideToIntegralValue(BigDecimal.valueOf(divideCount));
            // 取余
            BigDecimal remainder = dcmNumber.remainder(BigDecimal.valueOf(divideCount));

            System.out.println(String.format("原始值：%s; 分割次数：%s; 平均值：%s; 余数为：%s", dcmNumber, divideCount, average, remainder));
        }

    }

    public static void getTest(){
        BigDecimal bigDecimal  = BigDecimal.ZERO;
        Map map = new HashMap<>();
        map.put("a",bigDecimal);
        String str = (String)map.get("a");
        System.out.println(str);
    }

    public static void decimalTest(){
        System.out.println(new BigDecimal("-2.321").setScale(2, RoundingMode.DOWN));
    }
}
