package com.zkzong.reflect;

/**
 * Created by Zong on 2016/11/22.
 */
public class GetSuperclass {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> personClass = Class.forName("com.zkzong.reflect.Person");

            // 获取父类
            Class<?> superclass = personClass.getSuperclass();

            System.out.println(superclass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
