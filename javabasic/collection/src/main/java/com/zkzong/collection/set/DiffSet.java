package com.zkzong.collection.set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zong on 2016/10/11.
 */
public class DiffSet {
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
}
