package com.zkzong.collection.set;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zong on 2016/7/26.
 */
public class IterSet {
    /**
     * set遍历的两种方法：foreach和iterator
     */
    @Test
    public void iterSet() {
        Set set = new HashSet();
        set.add(1);
        set.add(2);

        for (Object i : set) {
            System.out.println(i);
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }

    @Test
    public void iterSetWithNull() {
        Set<Integer> hashSet = new HashSet<Integer>();

        hashSet.add(2);
        hashSet.add(5);
        hashSet.add(1);
        hashSet.add(null);  // will throw null pointer
        hashSet.add(999);
        hashSet.add(10);
        hashSet.add(10);
        hashSet.add(11);
        hashSet.add(9);
        hashSet.add(10);
        hashSet.add(000);
        hashSet.add(999);
        hashSet.add(0);

        Iterator<Integer> it = hashSet.iterator();
        // 遍历报NPE
        // 遍历set时需要把值拆箱为基本数据类型，如果值为null，JVM试图把它拆箱为基本数据类型就会导致NPE。
        // 装箱:Integer.valueOf(100)
        // 拆箱：i.intValue()
        while (it.hasNext()) {
            // 拆箱：相当于null调用intValue()方法，所以报NPE
            int i = it.next();
            System.out.print(i + " ");
        }
        // 正确遍历
        while (it.hasNext()) {
            final Integer i = it.next();
            System.out.print(i + " ");
        }
    }

    /**
     * key和value相同即可删除
     */
    @Test
    public void remove() {
        // LinkedHashSet有序
        Set<Map<String, Object>> set = new LinkedHashSet<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("f0", "10以下");
        set.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("f1", "10-19");
        set.add(map2);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("f2", "20-29");
        set.add(map3);
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("f3", "30以上");
        set.add(map4);
        System.out.println(set);

        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("f2", "20-29");
        Set<Map<String, Object>> s = set;
        s.remove(map5);
        System.out.println(s);
    }
}
