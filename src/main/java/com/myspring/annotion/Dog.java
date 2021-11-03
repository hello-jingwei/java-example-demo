package com.myspring.annotion;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dog {
    String name() default "";
    String color() default "white";
}
