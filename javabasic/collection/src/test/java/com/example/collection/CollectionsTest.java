package com.example.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zong on 2016/12/7.
 */
public class CollectionsTest {

    /**
     * 排序
     */
    @Test
    public void list() {
        List list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(9);
        Collections.sort(list);
        System.out.println(list); // [2, 3, 5, 7, 9]
    }

    /**
     * 内置方法
     */
    @Test
    public void method() {
        List list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("a" + i);
        }
        System.out.println(list);
        Collections.shuffle(list); // 随机排序
        System.out.println(list);
        Collections.reverse(list); // 逆序
        System.out.println(list);
        Collections.sort(list); // 排序
        System.out.println(list);

        System.out.println(Collections.binarySearch(list, "a2"));

        Collections.fill(list, "hello");
        System.out.println(list);
    }

    /**
     * 转换线程安全集合
     */
    @Test
    public void map() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        Map<String, String> synchronizedMap = Collections.synchronizedMap(map);
        System.out.println(synchronizedMap);
    }

    /**
     * 空集合
     */
    @Test
    public void empty() {
        List<Object> list = Collections.emptyList();
        System.out.println(list == null); // false

        Map<Object, Object> map = Collections.emptyMap();
        System.out.println(map == null); // false

        Set<Object> set = Collections.emptySet();
        System.out.println(set == null); // false
    }

    /**
     * 二分查找
     */
    @Test
    public void binarySearch() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        // 二分查找
        int i = Collections.binarySearch(list, 4);
        System.out.println(i);
    }

    /**
     * 转换成不可修改集合
     */
    @Test(expected = UnsupportedOperationException.class)
    public void unmodify() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        List<Integer> integers = Collections.unmodifiableList(list);
        integers.add(4);
        System.out.println(integers);

    }

}
