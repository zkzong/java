package com.zkzong.hutool.http;

import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.HashMap;

public class HttpTest {

    @Test
    public void get() {
        //GET请求
        String content = HttpUtil.get("https://www.baidu.com");
        System.out.println(content);
    }

    @Test
    public void post() {
        //POST请求
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", "long");

        String result = HttpUtil.post("http://localhost:8080/post", paramMap);
        System.out.println(result);
    }

    @Test
    public void postjson() {
        //POST请求
        User user = new User();
        user.setId(1);
        user.setName("long");
        user.setAge(30);
        user.setSex('M');

        Gson gson = new Gson();
        String json = gson.toJson(user);

        String result = HttpUtil.post("http://localhost:8080/post/json", json);
        System.out.println(result);
    }
}
