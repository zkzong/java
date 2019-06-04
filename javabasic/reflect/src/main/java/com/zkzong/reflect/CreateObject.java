package com.zkzong.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Zong on 2016/11/23.
 */
public class CreateObject {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> peopleClass = Class.forName("com.zkzong.reflect.People");

            // 无参构造函数
            Object object = peopleClass.newInstance();

            // 有参构造函数：一个参数
            Constructor<?> constructor = peopleClass.getDeclaredConstructor(String.class);
            constructor.newInstance("1000");

            // 有参构造函数：二个参数
            Constructor<?> constructor2 = peopleClass.getDeclaredConstructor(String.class, String.class);
            constructor2.newInstance("1000", "jack");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
