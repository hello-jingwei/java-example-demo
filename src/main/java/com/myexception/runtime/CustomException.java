package com.myexception.runtime;

/**
 * 运行时异常是一种调用方不可控的异常，不需要主动捕获或者用throws声明，区别于检查异常
 */
public class CustomException extends RuntimeException {
    private String message;

    CustomException() {
        super("自定义运行时异常！");
    }

    CustomException(String message) {
        super(message);
        this.message = message;
    }
}
