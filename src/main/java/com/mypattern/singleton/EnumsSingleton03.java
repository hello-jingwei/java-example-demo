package com.mypattern.singleton;

/**
 * 枚举方式创建单例
 */
public enum  EnumsSingleton03 {

    SERVER_A {
        @Override
        protected void hello() {
            System.out.println("hello server a");
        }
    },

    SERVER_B {
        @Override
        protected void hello() {
            System.out.println("hello server b");
        }
    };

    protected abstract void hello();
}

class Test{
    public static void main(String[] args) {
        EnumsSingleton03.SERVER_A.hello();
        EnumsSingleton03.SERVER_B.hello();
    }
}
