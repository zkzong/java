package com.example.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Zong on 2016/11/23.
 */
public class StaticFieldAndMethod {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> utilClass = Class.forName("com.example.reflect.Util");
            // 获取name属性
            Field name = utilClass.getDeclaredField("name");
            // 获取name的值
            String name_ = (String) name.get(name);
            // 输出值
            System.out.println(name_);

            // 没有返回值，没有参数
            Method getTips = utilClass.getDeclaredMethod("getTips");
            getTips.invoke(null);

            // 有返回值，没有参数
            Method getTip1 = utilClass.getDeclaredMethod("getTip");
            String result_1 = (String) getTip1.invoke(null);
            System.out.println("返回值：" + result_1);

            // 没有返回值，有参数
            Method getTip2 = utilClass.getDeclaredMethod("getTip", String.class);
            String result_2 = (String) getTip2.invoke(null, "第三个方法");
            System.out.println("返回值：" + result_2);

            // 有返回值，有参数
            // int.class不能换成Integer.class
            Method getTip3 = utilClass.getDeclaredMethod("getTip", int.class);
            String result_3 = (String) getTip3.invoke(null, 1);
            System.out.println("返回值：" + result_3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
