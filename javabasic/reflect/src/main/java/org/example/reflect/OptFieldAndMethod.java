package org.example.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Zong on 2016/11/23.
 */
public class OptFieldAndMethod {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> personClass = Class.forName("org.example.reflect.Person");

            // 创建实例
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

            // 获取setName方法
            Method setName = personClass.getDeclaredMethod("setName", String.class);
            // 打破封装
//            setName.setAccessible(true);
            // 调用setName方法
            setName.invoke(person, "jack");

            // 获取name字段
            Field name = personClass.getDeclaredField("name");
            // 打破封装
            name.setAccessible(true);

            // 打印person的id属性值
            String id_ = (String) id.get(person);
            System.out.println("id: " + id_);

            // 打印person的name属性值
            String name_ = (String) name.get(person);
            System.out.println("name: " + name_);

            // 获取getName方法
            Method getName = personClass.getDeclaredMethod("getName");
            // 打破封装
//            getName.setAccessible(true);

            // 执行getName方法，并且接受返回值
            String name_2 = (String) getName.invoke(person);
            System.out.println("name2: " + name_2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
