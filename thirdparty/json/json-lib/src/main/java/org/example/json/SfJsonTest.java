package org.example.json;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zong on 2016/8/11.
 */
public class SfJsonTest {
    public static void main(String[] args) {
        Person p1 = new Person("zong", 1);
        Person p2 = new Person("liu", 2);

        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);

        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
    }
}
