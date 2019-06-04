package com.zkzong.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by Zong on 2016/11/17.
 */
public class ReflectTest {

    // 反射机制获取类有三种方法
    @Test
    public void getClazz() throws ClassNotFoundException {
        // 第一种方式
        Class c1 = Class.forName("java.lang.String");
        // 第二种方式
        // java中每个类型都有class属性
        Class c2 = String.class;
        // 第三种方式
        // java语言中任何一个java对象都有getClass方法
        String s = new String();
        Class c3 = s.getClass();
    }

    @Test
    public void print() {
        String s = new String();
        // 获取类名
        System.out.println(s.getClass().getName());
        System.out.println(s.getClass().getSimpleName());

        // 获取类的方法
        Method[] methods = s.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
