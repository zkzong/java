package com.zkzong.collection.list;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zong on 2017/2/10.
 * 使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，它的add/remove/clear方法会抛出UnsupportedOperationException异常。
 * asList() 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。
 * 但是可以使用set方法修改元素值
 */
public class AsList {
    public static void main(String[] args) {
        String[] str = new String[]{"a", "b"};
        List list = Arrays.asList(str);
        list.add("c"); // 报错
        list.set(0, "aa"); // 不报错
        System.out.println(list);
    }
}
