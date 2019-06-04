package com.zkzong.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Zong on 2016/7/6.
 */
public class CollectionTest {
    public static void main(String[] args) {
        // HashMap无序
        Map m1 = new HashMap();
        m1.put("id", 1);
        m1.put("name", "zong");
        m1.put("age", 30);
        System.out.println(m1.toString());

        // LinkedHashMap有序：插入顺序
        Map m2 = new LinkedHashMap();
        m2.put("id", 1);
        m2.put("name", "zong");
        m2.put("age", 30);
        System.out.println(m2.toString());

        // TreeMap有序：key的自然顺序
        Map m3 = new TreeMap();
        m3.put("id", 1);
        m3.put("name", "zong");
        m3.put("age", 30);
        System.out.println(m3.toString());

        List l1 = new ArrayList();
        List l2 = new LinkedList();

        Set s1 = new HashSet();
        Set s2 = new TreeSet();
        Set s3 = new LinkedHashSet();
    }
}
