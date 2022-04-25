package com.test;

import java.security.SecureRandom;
import java.util.Random;

public class SecurityRandomTest {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 1; i++) {
            System.out.println(random.nextFloat());
        }
    }
}
