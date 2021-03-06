package com.zkzong.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zong on 2016/10/11.
 */
public class CollectTest {
    @Test
    public void set() {
        Set allSet = new LinkedHashSet();
        Map<String, Object> m1 = new HashMap<String, Object>();
        m1.put("id", 1);
        m1.put("name", "zong");
        allSet.add(m1);
        Map<String, Object> m2 = new HashMap<String, Object>();
        m2.put("id", 2);
        m2.put("name", "wang");
        allSet.add(m2);
        Map<String, Object> m3 = new HashMap<String, Object>();
        m3.put("id", 3);
        m3.put("name", "liu");
        allSet.add(m3);
        Map<String, Object> m4 = new HashMap<String, Object>();
        m4.put("id", 4);
        m4.put("name", "ma");
        allSet.add(m4);
        Map<String, Object> m5 = new HashMap<String, Object>();
        m5.put("id", 5);
        m5.put("name", "zhang");
        allSet.add(m5);
        System.out.println("allSet: " + allSet);

        Set set = new LinkedHashSet();
        Map<String, Object> m7 = new HashMap<String, Object>();
        m7.put("id", 5);
        m7.put("name", "zhang");
        set.add(m7);
        Map<String, Object> m6 = new HashMap<String, Object>();
        m6.put("id", 4);
        m6.put("name", "ma");
        set.add(m6);
        Map<String, Object> m8 = new HashMap<String, Object>();
        m8.put("id", 8);
        m8.put("name", "ma");
        set.add(m8);
        System.out.println("set: " + set);

        System.out.println("Sets.difference(allSet, set): " + Sets.difference(allSet, set));
        System.out.println("Sets.union(allSet, set): " + Sets.union(allSet, set));
        System.out.println("Sets.intersection(allSet, set): " + Sets.intersection(allSet, set));
    }

    @Test
    public void list() {
        List list = Lists.newArrayList();
        System.out.println(list.size());
        list = Lists.newArrayListWithCapacity(1);
        System.out.println(list.size());
        list = Lists.newArrayListWithExpectedSize(10);
        System.out.println(list.size());
    }

    @Test
    public void map() {
    }
}
