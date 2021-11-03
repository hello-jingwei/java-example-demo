package com.util.clazzfile;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
public class LineNo {
    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
//        List<String> l = null;
//        List<String> l2 = (List<String>)l;
//        System.out.println(l2);
//        System.out.println(new String("MDAwMDAwRpm9fwNNbjo=".getBytes(), StandardCharsets.UTF_8));
//        System.out.println(new String(ArrayUtils.subarray("000000abd".getBytes(),6,"000000abd".getBytes().length),StandardCharsets.UTF_8));
//        for (int i = 0; i < 15; i++) {
//            System.out.println(i + ":" + ((i & 1) == 0));
//        }
//        System.out.println(Runtime.getRuntime().availableProcessors());
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("hi");
//        System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
//        System.out.println(new BigDecimal("10").compareTo(new BigDecimal(11)));
    }


    public static void test() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
            if(i == 4) {
                throw new Exception("异常");
            }
            System.out.println(i);
        }
        System.out.println("hello");

    }
}
