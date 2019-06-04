package com.zkzong.reflect.example;

import com.zkzong.reflect.People;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GetMethod {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        People people = new People();
        people.setId(1);
        people.setName("zong");
        people.setAmount(new BigDecimal("100"));
        people.setAge(20);
        people.setSex(true);

        Class<? extends People> pClass = people.getClass();
        Field[] declaredFields = pClass.getDeclaredFields();

        Map<String, String> map = new HashMap<>();

        // 方法1 通过 拼接 get方法 获得 字段中的值
        for (Field field : declaredFields) {
            // 获得字符串名字
            String fieldName = field.getName();
            Class<?> type = field.getType();

            if (type == String.class) {
                System.out.println(fieldName + " : " + type);
            }
            if (type == Integer.class) {
                System.out.println(fieldName + " : " + type);
            }
            if (type == BigDecimal.class) {
                System.out.println(fieldName + " : " + type);
            }
            if (type == int.class) {
                System.out.println(fieldName + " : " + type);
            }
            if (type == boolean.class || type == Boolean.class) {
                System.out.println(fieldName + " : " + type);
            }
            // todo 数组和对象该如何处理

            // 字符串首字母大写
            char[] cs = fieldName.toCharArray();
            cs[0] -= 32;
            System.out.println(String.valueOf(cs));

            // 调用get方法
            Method method;
            if (type == boolean.class || type == Boolean.class) {
                method = pClass.getMethod("is" + String.valueOf(cs));
            } else {
                method = pClass.getMethod("get" + String.valueOf(cs));
            }

            // 得到值
            Object invoke = method.invoke(people);

            // 输出值
            System.out.println(invoke);

            map.put(fieldName, invoke.toString());
            System.out.println(map);
        }

        // 方法2 通过获得字段破坏封装后 直接获得对象的值
        for (Field field : declaredFields) {
            // 破坏封装属性 使字段 变为共有
            field.setAccessible(true);

            System.out.println(field.getName());

            // 取得对象中 该字段的值
            Object object = field.get(people);

            // 输出值
            System.out.println(object);
        }

    }
}