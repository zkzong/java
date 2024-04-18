package com.example.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap 遍历从大的方向来说，可分为以下 4 类：
 * <p>
 * 迭代器（Iterator）方式遍历；
 * For Each 方式遍历；
 * Lambda 表达式遍历（JDK 1.8+）;
 * Streams API 遍历（JDK 1.8+）。
 * 但每种类型下又有不同的实现方式，因此具体的遍历方式又可以分为以下 7 种：
 * <p>
 * 使用迭代器（Iterator）EntrySet 的方式进行遍历；
 * 使用迭代器（Iterator）KeySet 的方式进行遍历；
 * 使用 For Each EntrySet 的方式进行遍历；
 * 使用 For Each KeySet 的方式进行遍历；
 * 使用 Lambda 表达式的方式进行遍历；
 * 使用 Streams API 单线程的方式进行遍历；
 * 使用 Streams API 多线程的方式进行遍历。
 * Created by Zong on 2016/8/12.
 */
public class IterMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        // 1.使用迭代器（Iterator）EntrySet 的方式进行遍历
        System.out.println("通过Map.entrySet使用iterator遍历key和value");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key=" + entry.getKey() + " and value=" + entry.getValue());
        }

        // 2.使用迭代器（Iterator）KeySet 的方式进行遍历
        System.out.println("通过Map.keySet使用iterator遍历key和value");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("key=" + key + " and value=" + map.get(key));
        }

        // 3.推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key=" + entry.getKey() + " and value=" + entry.getValue());
        }

        // 4.普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value");
        for (String key : map.keySet()) {
            System.out.println("key=" + key + " and value=" + map.get(key));
        }


        // 5.Java8 forEach
        System.out.println("Java 8使用forEach");
        map.forEach((key, value) -> System.out.println("key : " + key + " value : " + value));
        map.forEach((k, v) -> {
            System.out.println("key : " + k + " value : " + v);
            if ("1".equals(k)) {
                System.out.println("hello 1");
            }
        });

        // 6.Streams 单线程
        System.out.println("Streams 单线程");
        map.entrySet().stream().forEach(entry -> {
            System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
        });

        // 7.Streams 多线程
        System.out.println("Streams 多线程");
        map.entrySet().parallelStream().forEach(entry -> {
            System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
        });

        // 8
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value=" + v);
        }
    }
}
