package com.test;

import lombok.Data;

@Data
public class InnerClassTest {

    private InnerCls innerCls;

    @Data
    public static class InnerCls {
        private String propA;
    }
}
