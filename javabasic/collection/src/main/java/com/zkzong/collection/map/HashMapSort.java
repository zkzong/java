package com.zkzong.collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2016/7/22.
 */
public class HashMapSort {
    public static void main(String[] args) {
//        HashMap的值是没有顺序的，他是按照key的HashCode来实现的。
        Map<String, String> map = new HashMap<String, String>();
        map.put("d", "d");
        map.put("b", "b");
        map.put("a", "a");
        map.put("c", "c");

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            //升序排序
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + " : " + mapping.getValue());
        }
    }
}
