package com.myexception.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionTest01 {
    public static void main(String[] args) {
        exLog();
    }

    public static void exLog() {
        try {
            int i = Integer.parseInt("a1");
        } catch (Exception e) {
            log.error("系统异常：{}",e.getMessage(), e);
        }

    }
}
