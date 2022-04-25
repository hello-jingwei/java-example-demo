package com.mystream;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileInputStream {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\IO测试i.txt");
        java.io.FileInputStream fis = new java.io.FileInputStream(file);
        byte[] buffer = new byte[50];
        // 每次读取的字节数
        int readLength;
        // 读取数据并放到buffer数组中
        StringBuilder stringBuilder = new StringBuilder();
        while ((readLength = fis.read(buffer)) != -1) {
            // UTF-8为变长编码，一个汉字占3个字节
//            System.out.println("本次读取" + readLength + "个字节数据内容为:" + new String(buffer));
            stringBuilder.append(new String(buffer, StandardCharsets.UTF_8));
        }
        System.out.println(stringBuilder);

    }
}
