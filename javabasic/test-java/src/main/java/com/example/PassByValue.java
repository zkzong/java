package com.example;

class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class PassByValue {
    public static void main(String[] args) {
        Person xiaoZhang = new Person("小张");
        Person xiaoLi = new Person("小李");
        swap(xiaoZhang, xiaoLi);
        System.out.println("xiaoZhang:" + xiaoZhang.getName());
        System.out.println("xiaoLi:" + xiaoLi.getName());
    }

    public static void swap(Person person1, Person person2) {
        Person temp = person1;
        person1 = person2;
        person2 = temp;
        System.out.println("person1:" + person1.getName());
        System.out.println("person2:" + person2.getName());
    }
}



