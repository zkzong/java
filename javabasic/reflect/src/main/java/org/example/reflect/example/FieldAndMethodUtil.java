package com.example.reflect.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class FieldAndMethodUtil {

    /**
     * getDeclaredFields只能获取该类的字段，不能获取父类的字段
     *
     * @param obj
     * @return
     */
    public static Map<String, String> Object2Map(Object obj) {
        Map<String, String> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        common(obj, clazz, map);
        return map;
    }

    /**
     * 使用循环的方式遍历对象，并赋值给Map
     *
     * @param obj
     * @return
     */
    public static Map<String, String> Object2MapByLoop(Object obj) {
        Map<String, String> map = new HashMap<>();

        Class<?> objClass = obj.getClass();
        // 当父类为Object时不再获取字段
        while (objClass != Object.class) {
            common(obj, objClass, map);
            // 得到父类，然后赋给自己
            objClass = objClass.getSuperclass();
        }

        return map;
    }

    /**
     * 使用递归的方式遍历对象，并赋值给Map
     *
     * @param obj
     * @return
     */
    public static Map<String, String> Object2MapByRecursion(Object obj) {
        Map<String, String> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        return recursionObj(obj, clazz, map);
    }

    private static Map<String, String> recursionObj(Object obj, Class<?> clazz, Map<String, String> map) {
        if (clazz != Object.class) {
            common(obj, clazz, map);
            recursionObj(obj, clazz.getSuperclass(), map);
        }
        return map;
    }

    private static void common(Object obj, Class<?> clazz, Map<String, String> map) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            Class<?> type = declaredField.getType();

            // 字符串首字母大写
            char[] cs = name.toCharArray();
            cs[0] -= 32;

            Method method;
            try {
                if (type == boolean.class || type == Boolean.class) {
                    method = clazz.getMethod("is" + String.valueOf(cs));
                } else {
                    method = clazz.getMethod("get" + String.valueOf(cs));
                }
                Object value = method.invoke(obj);
                if (value != null) {
                    map.put(name, value.toString());
                }
            } catch (NoSuchMethodException e) {
                // 如serialVersionUID没有getter、setter方法，不抛出异常
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}
