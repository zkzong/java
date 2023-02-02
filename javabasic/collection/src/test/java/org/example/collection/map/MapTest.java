package org.example.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zong on 2016/7/14.
 */
public class MapTest {
    public static void main(String[] args) {
        //key相同时，后put的值会覆盖之前put的值
        Map map = new HashMap();
        map.put(1, 10);
        map.put(1, 11);
        System.out.println(map);

        Map m = new HashMap(16);
        m.put(null, 100);
        m.put("", 100);
        System.out.println(m);
    }

    @Test
    public void replace() {
        String s = "<html><body>${name}-${age}-${name}</body></html>";

        Map<String, String> m = new HashMap<>();
        m.put("name", "zong");
        m.put("age", "30");

        for (Map.Entry<String, String> entry : m.entrySet()) {
            s = s.replace("${" + entry.getKey() + "}", entry.getValue());
        }
        System.out.println(s);
    }
}
