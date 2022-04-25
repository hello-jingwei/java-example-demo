package com.mystream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class ObjOutStream {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\IO测试i.obj");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);

        Person p1 = new Person();                                            //定义两个对象

        p1.setName("福国");
        p1.setYear(23);
        p1.setBirth(new Date(95,6,12));

        objectOutputStream.writeObject(p1);

        objectOutputStream.close();
    }
}


class Person implements Serializable {
    public String name;
    public int year;
    public Date birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /*
     *重写toString函数，返回内容包括名字，年龄和生日
     */
    public String toString() {
        return name.toString() + " " + year + " " + birth.toString();
    }
}

