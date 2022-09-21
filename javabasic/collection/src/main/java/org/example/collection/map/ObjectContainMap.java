package org.example.collection.map;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zkzong
 * @Date: 2018.10.9
 */
public class ObjectContainMap {

    @Test
    public void test() {
        ObjectMap objectMap = new ObjectMap();
        objectMap.setName("zong");
        objectMap.setAge(30);
        Map<String, String> map = new HashMap<>(4);
        map.put("a", "a");
        map.put("b", "b");
        objectMap.setMap(map);
        String str = JSON.toJSONString(objectMap);
        System.out.println(str);
    }

}