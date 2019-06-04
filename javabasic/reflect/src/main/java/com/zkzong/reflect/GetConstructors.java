package com.zkzong.reflect;

import java.lang.reflect.Constructor;

/**
 * Created by Zong on 2016/11/22.
 */
public class GetConstructors {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> personClass = Class.forName("com.zkzong.reflect.Person");

            // 获取所有的构造方法
            Constructor<?>[] constructors = personClass.getConstructors();

            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
