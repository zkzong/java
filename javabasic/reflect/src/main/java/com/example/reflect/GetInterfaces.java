package com.example.reflect;

/**
 * Created by Zong on 2016/11/22.
 */
public class GetInterfaces {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> personClass = Class.forName("com.example.reflect.Person");

            // 获取所有的接口
            Class<?>[] interfaces = personClass.getInterfaces();

            for (Class<?> clazz : interfaces) {
                System.out.println(clazz);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
