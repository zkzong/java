package com.example.reflect;

/**
 * Created by Zong on 2016/11/22.
 */
public class GetClass {
    public static void main(String[] args) {
        // 第一种方法：forName
        try {
            Class<?> class1 = Class.forName("com.example.reflect.Person");
            System.out.println(class1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 第二种方法：class
        Class<?> class2 = Person.class;

        // 第三种方法：getClass
        Person person = new Person();
        Class<?> class3 = person.getClass();

        System.out.println(class2);
        System.out.println(class3);
    }
}
