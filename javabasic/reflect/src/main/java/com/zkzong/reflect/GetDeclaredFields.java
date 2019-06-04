package com.zkzong.reflect;

import java.lang.reflect.Field;

/**
 * Created by Zong on 2016/11/22.
 */
public class GetDeclaredFields {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> personClass = Class.forName("com.zkzong.reflect.Person");

            // 获取本类的全部属性
            Field[] declaredFields = personClass.getDeclaredFields();

            for (Field declaredField : declaredFields) {
                System.out.println(declaredField);
            }

            Field[] fields = personClass.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
            // getFields()获得某个类的所有的公共（public）的字段，包括父类。
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
