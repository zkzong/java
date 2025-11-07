package com.example.hutool.util;

import cn.hutool.json.JSONUtil;
import com.example.hutool.util.entity.Man;
import org.junit.Test;

public class JsonUtilTest {

    @Test
    public void toBean() {
        String json = "{\"userName\":\"张三\",\"age\":18,\"sex\":\"1\"}";
        Man man = JSONUtil.toBean(json, Man.class);
        System.out.println(man);
    }

    @Test
    public void test() {
        Man man= new Man();
        man.setUserName("Jack");
        man.setAge(10);
        String jsonStr = JSONUtil.toJsonStr(man);
        System.out.println(jsonStr);
    }
}
