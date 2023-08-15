package com.example.reflect;

/**
 * Created by Zong on 2016/11/22.
 */
public class NewInstance {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> personClass = Class.forName("com.example.reflect.Person");

            // 创建实例化：相当于new了一个对象
            Object object = personClass.newInstance();

            // 向下转型
            Person person = (Person) object;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
