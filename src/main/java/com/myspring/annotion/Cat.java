package com.myspring.annotion;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class Cat {
    private String name;

    public Cat() {
        System.out.println("Cat......constructor............");
    }

    public void init() {
        System.out.println("Cat......init............");
    }

    public void destroyMethod() {
        System.err.println("cat....destroyMethod.....");
    }

    @Bean(initMethod = "init", destroyMethod = "destroyMethod")
    public Cat buildCat() {
        Cat cat = new Cat();
        cat.setName("花花");
        return cat;
    }
}
