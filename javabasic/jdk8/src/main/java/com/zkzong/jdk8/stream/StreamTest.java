package com.zkzong.jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    @Test
    public void groupingBy() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("id", "1");
        map1.put("idNo", "1234");
        list.add(map1);
        Map<String, String> map2 = new HashMap<>();
        map2.put("id", "2");
        map2.put("idNo", "1234");
        list.add(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("id", "1");
        map3.put("idNo", "2345");
        list.add(map3);
        Map<String, String> map4 = new HashMap<>();
        map4.put("id", "2");
        map4.put("idNo", "2345");
        list.add(map4);
        System.out.println(list);

        // 根据idNo分组
        Map<String, List<Map<String, String>>> maps = list.stream().collect(Collectors.groupingBy((Map<String, String> m) -> m.get("idNo")));
        System.out.println(maps);
        Set<Map.Entry<String, List<Map<String, String>>>> entries = maps.entrySet();
        for (Map.Entry<String, List<Map<String, String>>> entry : entries) {
            List<Map<String, String>> l = entry.getValue();
            System.out.println(l);
            System.out.println(entry);
        }
    }
}
