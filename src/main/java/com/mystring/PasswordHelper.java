package com.mystring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordHelper {
    public static boolean checkPassword(String password){
        String regExp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(checkPassword("Aa#%!^**1"));
    }
}
