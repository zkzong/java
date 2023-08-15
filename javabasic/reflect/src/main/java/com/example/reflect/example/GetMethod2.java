package com.example.reflect.example;

import com.example.reflect.People;
import com.example.reflect.Person;

import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Description:根据属性名反射获取get和set方法
 */
public class GetMethod2 {

    public static void main(String[] args) throws Exception {
        // test removeLine
        System.out.println(removeLine("abg_dwr"));
        System.out.println(removeLine("ab_wr"));
        System.out.println(removeLine("abgwr"));
        System.out.println(removeLine(null));

        // test get
        People people1 = new People();
        people1.setId(11);
        people1.setName("旺旺");
        Object ob = getGetMethod(people1, "name");
        System.out.println(ob);

        // test set
        People people2 = new People();
        String field2 = "name";
        setValue(people2, people2.getClass(), field2, Person.class.getDeclaredField(field2).getType(), "汪汪");
        System.out.println(people2);
        // 获取某个属性的类型
        System.out.println(Person.class.getDeclaredField("age").getType());

    }

    /**
     * 根据属性，获取get方法
     *
     * @param ob   对象
     * @param name 属性名
     * @return
     * @throws Exception
     */
    public static Object getGetMethod(Object ob, String name) throws Exception {
        Method[] m = ob.getClass().getMethods();
        for (int i = 0; i < m.length; i++) {
            if (("get" + name).toLowerCase().equals(m[i].getName().toLowerCase())) {
                return m[i].invoke(ob);
            }
        }
        return null;
    }

    /**
     * 根据属性，拿到set方法，并把值set到对象中
     *
     * @param obj       对象
     * @param clazz     对象的class
     * @param fieldName 需要设置值得属性
     * @param typeClass
     * @param value
     */
    public static void setValue(Object obj, Class<?> clazz, String fieldName, Class<?> typeClass, Object value) {
        fieldName = removeLine(fieldName);
        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        try {
            Method method = clazz.getDeclaredMethod(methodName, new Class[]{typeClass});
            method.invoke(obj, new Object[]{getClassTypeValue(typeClass, value)});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 通过class类型获取获取对应类型的值
     *
     * @param typeClass class类型
     * @param value     值
     * @return Object
     */
    private static Object getClassTypeValue(Class<?> typeClass, Object value) {
        if (typeClass == int.class || value instanceof Integer) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == short.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == byte.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == double.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == long.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == String.class) {
            if (null == value) {
                return "";
            }
            return value;
        } else if (typeClass == boolean.class) {
            if (null == value) {
                return true;
            }
            return value;
        } else if (typeClass == BigDecimal.class) {
            if (null == value) {
                return new BigDecimal(0);
            }
            return new BigDecimal(value + "");
        } else {
            return typeClass.cast(value);
        }
    }

    /**
     * 处理字符串  如：  abc_dex ---> abcDex
     *
     * @param str
     * @return
     */
    public static String removeLine(String str) {
        if (null != str && str.contains("_")) {
            int i = str.indexOf("_");
            char ch = str.charAt(i + 1);
            char newCh = (ch + "").substring(0, 1).toUpperCase().toCharArray()[0];
            String newStr = str.replace(str.charAt(i + 1), newCh);
            String newStr2 = newStr.replace("_", "");
            return newStr2;
        }
        return str;
    }
}