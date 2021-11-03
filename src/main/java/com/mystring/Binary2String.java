package com.mystring;

import java.io.Serializable;

public class Binary2String {
    private String keyPrefix = "tms_shipper_shiro_redis_session:";

    public static void main(String[] args) {
        String str = "123";
        byte[] bytes = str.getBytes();
        System.out.println(bytes);

    }


    private byte[] getByteKey(Serializable sessionId) {
        String preKey = this.keyPrefix + sessionId;
        return preKey.getBytes();
    }
}
