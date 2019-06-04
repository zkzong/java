package com.zkzong.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zong on 2017/2/10.
 */
public class ToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");

        // 直接使用 toArray() 无参方法返回值只能是 Object[]类，若强转其它类型数组将会抛异常。
        String[] arr = (String[]) list.toArray();
        System.out.println(arr);

        // 使用 <T> T[] toArray(T[] a); 有参数这个方法
        String[] array = new String[list.size()];
        array = list.toArray(array);
        for (int i = 0; i < array.length; i++) {
            String s = array[i];
            System.out.println(s);
        }
    }
}
