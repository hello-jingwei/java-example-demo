package com.jvm.obj;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

public class ObjSize {

    private static final String JY_POUND_REQ_URL = "/poundData/addOrUpdate";
    public static void main(String[] args) {

        System.out.println("/poundData/addOrUpdate?123456".contains(JY_POUND_REQ_URL));
    }
}
