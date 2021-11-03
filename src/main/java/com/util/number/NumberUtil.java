package com.util.number;

import java.util.regex.Pattern;

public class NumberUtil {
    public static boolean isNumeric(String str) {
        if (str == null || "".equals(str)){
            return false;
        }
        Pattern pattern = Pattern.compile("^(-|\\+)?\\d+(\\.\\d+)?$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("123.1234"));
    }
}
