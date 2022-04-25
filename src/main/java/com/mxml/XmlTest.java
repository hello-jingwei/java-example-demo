package com.mxml;

import java.util.Date;

public class XmlTest {
    public static void main(String[] args) {
        // 创建需要转换的对象
        User user = new User(1, "Steven", null, null, 1000.0);
        Animal animal = new Animal(1,"gray");
        World world = new World(user, animal);
        Body<User> body = new Body<>();
        body.setValue(user);
        body.setWorld(world);
        System.out.println("---将对象转换成string类型的xml Start---");
        // 将对象转换成string类型的xml
        String str = XmlUtil.convertToXml(body);
        // 输出
        System.out.println(str);
        System.out.println("---将String类型的xml转换成对象 Start---");
        Body wordObj = XmlUtil.convertXmlStrToObject(Body.class, str);
        System.out.println(wordObj);
    }

}
