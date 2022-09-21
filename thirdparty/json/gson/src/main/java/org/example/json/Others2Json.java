package org.example.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zong on 2016/8/11.
 */
public class Others2Json {
    public static void main(String[] args) {
        Person p1 = new Person("zong", 1);
        Person p2 = new Person("liu", 2);
        Person p3 = new Person("ma", 3);

        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        Set<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        Gson gson = new Gson();

        System.out.println("List转JSON");
        String jsonStr = gson.toJson(list);
        System.out.println(jsonStr);
        System.out.println(gson.toJsonTree(list));

        System.out.println("Set转JSON");
        String jsonSetStr = gson.toJson(set);
        System.out.println(jsonSetStr);
        System.out.println(gson.toJsonTree(set));

        System.out.println("Map转JSON");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("name", "zong");

        List l = new ArrayList();
        Map<String, Object> m1 = new HashMap<String, Object>();
        m1.put("a", "a");
        m1.put("b", "b");
        l.add(m1);
        Map<String, Object> m2 = new HashMap<String, Object>();
        m2.put("c", "c");
        m2.put("d", "d");
        l.add(m2);

        map.put("list", l);
        System.out.println(gson.toJson(map));

        System.out.println("Array转JSON");
        String[] strArray = {"zong", "liu", "ma"};
        System.out.println(gson.toJson(strArray));
    }

    @Test
    public void null2Json() {
        Map m = new HashMap();
        m.put("null", null);
        // 默认属性值为null的字段不返回
        Gson gson = new Gson();
        System.out.println(gson.toJson(m));
        // 属性值为null的字段返回，值为null
        gson = new GsonBuilder().serializeNulls().create();
        System.out.println(gson.toJson(m));
    }
}
