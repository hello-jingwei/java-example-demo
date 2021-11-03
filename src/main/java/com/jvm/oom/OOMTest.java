package com.jvm.oom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * JVM内存参数设置：
 *  -Xms100M -Xmx100M
 */
public class OOMTest {
    public static void main(String[] args) {
        new OOMTest().oom();
    }

    public void oom(){
        List<User> users = new ArrayList<>();
        while (true) {
            User user = new User();
            String uuid = UUID.randomUUID().toString();
            user.setId("000001" + uuid);
            user.setId("张三" + uuid);
            users.add(user);
        }
    }
}

class User{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
