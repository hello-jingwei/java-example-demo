package com.mystring;

/**
 * @author wjw
 */
public class String01 {
    public static void main(String[] args) {
        String code = "201909(红)065";
        StringBuffer buffer = new StringBuffer();
        buffer.append(code.substring(0,9));
        buffer.append(String.format("%03d", Integer.valueOf(code.substring(9,12))+1));
        System.out.println(buffer);

    }
}
