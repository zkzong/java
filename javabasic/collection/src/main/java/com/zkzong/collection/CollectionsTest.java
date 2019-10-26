package com.zkzong.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2016/12/7.
 */
public class CollectionsTest {
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

    @Test
    public void map() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        Map<String, String> synchronizedMap = Collections.synchronizedMap(map);
        System.out.println(synchronizedMap);
    }
}
