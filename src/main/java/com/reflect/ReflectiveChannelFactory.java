package com.reflect;

import java.lang.reflect.Field;

public class ReflectiveChannelFactory<T extends Object> {
    public final Class<? extends T> clazz;


    public ReflectiveChannelFactory(Class<? extends T> clazz){
        if (clazz == null) {
            throw new NullPointerException("clazz");
        } else {
            this.clazz = clazz;
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        String fieldName = new ReflectInnerClazz().getClazz().getClass().getField("clazz").getType().getName();
        System.out.println(fieldName);
    }

    static class ReflectInnerClazz {
        public static String prop = "prop";

        ReflectInnerClazz() {
            System.out.println("inner class");
        }

        public ReflectiveChannelFactory getClazz() {
            return new ReflectiveChannelFactory(ReflectInnerClazz.class);
        }
    }
}

