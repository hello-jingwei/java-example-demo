package com.mxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// xml解析类型
@XmlAccessorType(XmlAccessType.FIELD)
// 根节点元素
//@XmlRootElement(name = "world")
// 控制绑定顺序
@XmlType(propOrder = {"user","animal"})
public class World {
    private User user;
    private Animal animal;

    public World(){}

    public World(User user, Animal animal) {
        this.user = user;
        this.animal = animal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "World{" +
                "user=" + user +
                ", animal=" + animal +
                '}';
    }
}
