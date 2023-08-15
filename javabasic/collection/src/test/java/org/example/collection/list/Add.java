package com.example.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2016/11/28.
 */
public class Add {
    public static void main(String[] args) {
//        List list = new ArrayList(10);
//        list.add(1, 1);

        String[] arr = new String[5];
        System.out.println(arr[0]); // null
    }

    @Test
    public void add() {
        // 先把map添加到list，再修改map值
        Map<String, String> map = new HashMap<String, String>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list.add(map);
        map.put("id", "id");
        map.put("name", "name");
        map.put("age", "age");
        System.out.println(list.size());
        System.out.println(list.get(0).get("id"));

    }
}
