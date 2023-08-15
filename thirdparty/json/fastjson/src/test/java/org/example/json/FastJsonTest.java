package com.example.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FastJsonTest {

    /**
     * 排序
     */
    @Test
    public void sort() {
        User user = new User();
        user.setId(1L);
        user.setName("zong");
        user.setAge(18);
        System.out.println(user);
        System.out.println(JSON.toJSONString(user));
        String s = JSON.toJSONString(user, SerializerFeature.MapSortField);
        System.out.println(s);

        Map map = new HashMap();
        map.put("id", 1L);
        map.put("name", "zong");
        map.put("age", 18);
        System.out.println(JSON.toJSONString(map));
        String s1 = JSON.toJSONString(map, SerializerFeature.MapSortField);
        System.out.println(s1);
    }

    /**
     * jsonObject
     */
    @Test
    public void jsonObject() {
        String s = "{\"id\":1,\"name\":\"zong\",\"age\":18}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        String id = jsonObject.get("id").toString();
        String name = jsonObject.get("name").toString();
        System.out.println(id);
        System.out.println(name);

        s = "{\n" +
                "    \"data\":{\n" +
                "        \"balance\":\"0.0\"\n" +
                "    }\n" +
                "}";
        jsonObject = JSONObject.parseObject(s);
        String balance = jsonObject.getJSONObject("data").get("balance").toString();
        System.out.println(balance);
    }

}
