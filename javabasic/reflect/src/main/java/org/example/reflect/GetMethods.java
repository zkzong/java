package org.example.reflect;

import java.lang.reflect.Method;

/**
 * Created by Zong on 2016/11/22.
 * 获取所有公有方法
 */
public class GetMethods {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> personClass = Class.forName("org.example.reflect.Person");

            // 获取所有的方法
            Method[] methods = personClass.getMethods();

            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
