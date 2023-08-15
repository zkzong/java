package com.example.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zong on 2017/3/19.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String[]> m = new HashMap<String, String[]>();
        m.put("a", new String[]{"aaa"});

        Map mm = new HashMap();
        for (Map.Entry entry : m.entrySet()) {
            String[] value = (String[]) entry.getValue();
            System.out.println(value[0]);
            mm.put(entry.getKey(), entry.getValue());
        }
        System.out.println(mm);
    }
}
