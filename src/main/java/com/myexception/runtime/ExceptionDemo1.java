package com.myexception.runtime;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        new ExceptionDemo1().exceptionTest1();
    }

    public void exceptionTest1() throws CustomException{
        throw new CustomException("异常123");
    }
}
