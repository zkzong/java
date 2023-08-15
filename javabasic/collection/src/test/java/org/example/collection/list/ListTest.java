package com.example.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2016/10/10.
 */
public class ListTest {
    @Test
    public void AddValue() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id", 1);
        map1.put("name", "zong");
        list.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", 2);
        map2.put("name", "liu");
        list.add(map2);

        // 遍历修改list中对象的值
        handle(list);

        System.out.println(list);
    }

    private void handle(List<Map<String, Object>> list) {
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> m = list.get(i);
            m.put("age", i + 20);
        }
    }

    @Test
    public void c() {
        List<String> strings = new ArrayList<>();
        strings.add("135");
        System.out.println(strings);

        if (strings.contains("135")) {
            strings.add("137");
        }
        System.out.println(strings);

    }

    /**
     * 修改list值
     */
    @Test
    public void modify() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list);

        list.set(1, "1111");
        System.out.println(list);
    }

}
