package org.example.reflect;

import java.lang.reflect.Field;

/**
 * Created by Zong on 2016/11/23.
 */
public class OptField {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> personClass = Class.forName("org.example.reflect.Person");

            // 创建实例化：相当于new了一个对象
            Object person = personClass.newInstance();

            // 获得id属性
            Field id = personClass.getDeclaredField("id");
            // id属性是private私有的，不能修改它的值
            // 如果要修改需要把setAccessible设置为true
            // 打破封装  实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问
            // 由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的
            id.setAccessible(true);
            // 给id属性赋值
            id.set(person, "100");
            // 打印person的属性值
            System.out.println(id.get(person));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
