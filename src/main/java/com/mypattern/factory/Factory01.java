package com.mypattern.factory;

/**
 * 1、公共类型接口；
 * 2、接口实现类；
 * 3、工厂类，根据入参判断生产哪种实例对象；
 */
public class Factory01 {
    public static void main(String[] args) {
        new AnimalFactory().getAnimal("cat").run();
        new AnimalFactory().getAnimal("rabbit").run();
    }
}


class Rabbit implements Animal{
    private String name;

    public Rabbit(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "在跑.");
    }
}

class Cat implements Animal{
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "在跑.");
    }
}

interface Animal {
    void run();
}

class AnimalFactory {
    Animal getAnimal(String animalType) {
        if("cat".equals(animalType)) {
            return new Cat("猫");
        }
        if("rabbit".equals(animalType)) {
            return new Rabbit("兔子");
        }
        return null;
    }
}
