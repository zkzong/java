package org.example.collection.set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Zong on 2016/10/11.
 */
public class SetTest {
    @Test
    public void diff() {
        Set allSet = new LinkedHashSet();
        Map<String, Object> m1 = new LinkedHashMap<String, Object>();
        m1.put("id", 1);
        m1.put("name", "zong");
        allSet.add(m1);
        Map<String, Object> m2 = new LinkedHashMap<String, Object>();
        m2.put("id", 2);
        m2.put("name", "wang");
        allSet.add(m2);
        Map<String, Object> m3 = new LinkedHashMap<String, Object>();
        m3.put("id", 3);
        m3.put("name", "liu");
        allSet.add(m3);
        Map<String, Object> m4 = new LinkedHashMap<String, Object>();
        m4.put("id", 4);
        m4.put("name", "ma");
        allSet.add(m4);
        Map<String, Object> m5 = new LinkedHashMap<String, Object>();
        m5.put("id", 5);
        m5.put("name", "zhang");
        allSet.add(m5);
        System.out.println(allSet);

        Set set = new LinkedHashSet();
        Map<String, Object> m7 = new LinkedHashMap<String, Object>();
        m7.put("id", 5);
        m7.put("name", "zhang");
        set.add(m7);
        Map<String, Object> m6 = new LinkedHashMap<String, Object>();
        m6.put("id", 4);
        m6.put("name", "ma");
        set.add(m6);
        System.out.println(Sets.difference(allSet, Sets.difference(allSet, set)));

        // Sets.difference操作之后的结果不能直接转成json，需要new HashSet()之后再转换
        Sets.SetView difference = Sets.difference(allSet, Sets.difference(allSet, set));
        System.out.println("difference: " + difference);
        Set diff = new HashSet(difference);
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("diff", diff);
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(m));
        System.out.println(m);

    }


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
        Set<Integer> hashSet = new HashSet<>();

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
        Set<Map<String, Object>> set = new LinkedHashSet<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("f0", "10以下");
        set.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("f1", "10-19");
        set.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("f2", "20-29");
        set.add(map3);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("f3", "30以上");
        set.add(map4);
        System.out.println(set);

        Map<String, Object> map5 = new HashMap<>();
        map5.put("f2", "20-29");
        Set<Map<String, Object>> s = set;
        s.remove(map5);
        System.out.println(s);
    }

    /**
     * list to set
     */
    @Test
    public void list2set() {
        User u1 = new User("zong", 20);
        User u2 = new User("zong", 20);
        User u3 = new User("zong", 21);
        User u4 = new User("ma", 20);
        List<User> list = new ArrayList<User>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        System.out.println(list.size());

        Set<User> set = new HashSet<User>();
        set.addAll(list);
        System.out.println(set.size());

    }

    @Test
    public void setnull() {
        //TreeSet add null 运行报错
        Set set1 = new TreeSet();
        //set1.add(null);
        assertThrows(NullPointerException.class, () -> set1.add(null));

        //HashSet add null 不报错
        Set set2 = new HashSet();
        set2.add(null);
    }
}
