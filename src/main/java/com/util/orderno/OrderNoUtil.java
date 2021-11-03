package com.util.orderno;


import org.apache.commons.lang3.RandomUtils;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 订单编号生成工具类
 */
public class OrderNoUtil extends Thread{
    /**
     * 订单号生成
     **/
    private static String ORDER_PREFIX = "PO";
    private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");
    public static final AtomicInteger SEQ = new AtomicInteger(1000);

//    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmss");

    public static String generateOrderNo(EnumUtil enumUtil) {
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        int maxLimit = 8999;
        if (SEQ.intValue() > maxLimit) {
            SEQ.getAndSet(1000);
        }
        return enumUtil.getPrefix() + dataTime.format(DateTimeFormatter.ofPattern(enumUtil.getFormat()))
                + getLocalIpSuffix() + SEQ.incrementAndGet();
    }

    private volatile static String IP_SUFFIX = null;

    private static String getLocalIpSuffix() {
        if (null != IP_SUFFIX) {
            return IP_SUFFIX;
        }
        try {
            synchronized (OrderNoUtil.class) {
                if (null != IP_SUFFIX) {
                    return IP_SUFFIX;
                }
                InetAddress addr = InetAddress.getLocalHost();
                String hostAddress = addr.getHostAddress();
                if (null != hostAddress && hostAddress.length() > 4) {
                    String ipSuffix = hostAddress.trim().split("\\.")[3];
                    if (ipSuffix.length() == 2) {
                        IP_SUFFIX = ipSuffix;
                        return IP_SUFFIX;
                    }
                    ipSuffix = "0" + ipSuffix;
                    IP_SUFFIX = ipSuffix.substring(ipSuffix.length() - 2);
                    return IP_SUFFIX;
                }
                IP_SUFFIX = RandomUtils.nextInt(10, 20) + "";
                return IP_SUFFIX;
            }
        } catch (Exception e) {
            System.out.println("获取IP失败:" + e.getMessage());
            IP_SUFFIX = RandomUtils.nextInt(10, 20) + "";
            return IP_SUFFIX;
        }
    }


    public static void main(String[] args) {
        OrderNoUtil o1 = new OrderNoUtil();
        OrderNoUtil o2 = new OrderNoUtil();
        OrderNoUtil o3 = new OrderNoUtil();
        OrderNoUtil o4 = new OrderNoUtil();
        o1.start();
        o2.start();
        o3.start();
        o4.start();
    }

    public void genTest() {
        List<String> orderNos = Collections.synchronizedList(new ArrayList<String>());
        IntStream.range(0, 2000).parallel().forEach(i -> {
            orderNos.add(generateOrderNo(EnumUtil.JS));
        });

        List<String> filterOrderNos = orderNos.stream().distinct().collect(Collectors.toList());

        System.out.println("样例：" + orderNos.get(0));
        System.out.println("生成订单数：" + orderNos.size());
        System.out.println("过滤重复后订单数：" + filterOrderNos.size());
        System.out.println("重复订单数：" + (orderNos.size() - filterOrderNos.size()));
    }

    @Override
    public void run() {
        genTest();
    }
}
