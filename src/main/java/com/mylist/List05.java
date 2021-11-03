package com.mylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * remove
 */
public class List05 {
    public static void main(String[] args) {
        correctRemove();
    }

    /**
     * 异常情况
     * remove(object)调用fastRemove(index)对modCount++导致期望的count和实际的count不一致
     */
    public static void incorrectRemove(){
        List<String> list = new ArrayList<>();

        list.add("a");

        list.add("b");

        list.add("c");

        list.add("d");

        for (String s : list) {
            list.remove(s);

        }

        System.out.println(list);
    }

    public static void correctRemove(){
        List<String> list = new ArrayList<>();

        list.add("a");

        list.add("b");

        list.add("c");

        list.add("d");
        System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String el = (String)iterator.next();
            if(el.equals("a")) {
                iterator.remove();
            }
        }

        System.out.println(list);
    }
}
