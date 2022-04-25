package com.mystream;

import java.io.ByteArrayInputStream;

public class IOStream01 {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        System.out.println(byteArrayInputStream.available());
    }
}
