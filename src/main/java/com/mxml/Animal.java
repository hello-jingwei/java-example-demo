package com.mxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// xml解析类型
@XmlAccessorType(XmlAccessType.FIELD)
// 根节点元素
@XmlRootElement(name = "animal")
// 控制绑定顺序
@XmlType(propOrder = {"type","color"})
public class Animal {
    private Integer type;
    private String color;

    public Animal(){}

    public Animal(Integer type,String color) {
        this.type = type;
        this.color = color;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type=" + type +
                ", color='" + color + '\'' +
                '}';
    }
}
