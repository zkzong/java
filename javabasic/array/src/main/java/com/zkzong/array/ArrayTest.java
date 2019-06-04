package com.zkzong.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zong on 2016/7/21.
 */
public class ArrayTest {
    public static void main(String[] args) {

        int[] array = new int[10];
        System.out.println("array的父类是：" + array.getClass().getSuperclass());
        System.out.println("array的类名是：" + array.getClass().getName());

        Integer[] intArray = new Integer[10];
        System.out.println("intArray的父类是：" + intArray.getClass().getSuperclass());
        System.out.println("intArray的类名是：" + intArray.getClass().getName());

        int[] array_00 = new int[10];
        System.out.println("一维数组：" + array_00.getClass().getName());
        int[][] array_01 = new int[10][10];
        System.out.println("二维数组：" + array_01.getClass().getName());
        int[][][] array_02 = new int[10][10][10];
        System.out.println("三维数组：" + array_02.getClass().getName());
        /*Output:
        array的父类是：class java.lang.Object
        array的类名是：[I
        intArray的父类是：class java.lang.Object
        intArray的类名是：[Ljava.lang.Integer;
        一维数组：[I
        二维数组：[[I
        三维数组：[[[I
        */

        //[代表了数组的维度，一个[表示一维，两个[表示二维。可以简单的说数组的类名由若干个'['和数组元素类型的内部名称组成。

//        Element Type          Encoding
//        boolean               Z
//        byte                  B
//        char                  C
//        class or interface    Lclassname;
//        double                D
//        float                 F
//        int                   I
//        long                  J
//        short                 S

//        http://stackoverflow.com/questions/6867131/getclass-method-java-with-array-types#

        System.out.println("Object[]:" + Object[].class);
        System.out.println("Object[][]:" + Object[][].class);
        System.err.println("Object[][][]:" + Object[][][].class);
        System.out.println("Object:" + Object.class);
        /*Output:
        Object[]:class [Ljava.lang.Object;
        Object[][]:class [[Ljava.lang.Object;
        Object[][][]:class [[[Ljava.lang.Object;
        Object:class java.lang.Object*/

//        数组和普通的Java类是不同的，普通的java类是以全限定路径名+类名来作为自己的唯一标示的，而数组则是以若干个[+L+数组元素类全限定路径+类来最为唯一标示的。

        Class clazz = array.getClass();
        System.out.println(clazz.getDeclaredFields().length);
        System.out.println(clazz.getDeclaredMethods().length);
        System.out.println(clazz.getDeclaredConstructors().length);
        System.out.println(clazz.getDeclaredAnnotations().length);
        System.out.println(clazz.getDeclaredClasses().length);

        int[] datas = new int[]{1, 2, 3, 4, 5};
        List list = Arrays.asList(datas);
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(((int[]) o)[0]);
            System.out.println(((int[]) o)[1]);
            System.out.println(((int[]) o)[2]);
            System.out.println(((int[]) o)[3]);
            System.out.println(((int[]) o)[4]);
        }
        System.out.println(list.size());
        System.out.println(list.toString());
        System.out.println(datas.equals(list.get(0)));

    }
}
