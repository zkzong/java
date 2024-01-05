package com.example.hutool.http;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.HashMap;

public class HttpTest {

    private String postUrl = "http://localhost:8080/post";
    private String postJsonUrl = "http://localhost:8080/post/json";

    @Test
    public void get() {
        //GET请求
        String content = HttpUtil.get("https://www.baidu.com");
        System.out.println(content);
    }

    @Test(expected = IORuntimeException.class)
    public void post1() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", "long");

        //POST请求
        String result = HttpUtil.post(postUrl, paramMap);
        System.out.println(result);
    }

    @Test(expected = IORuntimeException.class)
    public void post2() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", "long");

        //链式构建请求
        String result = HttpRequest.post(postUrl)
                .header(Header.CONTENT_TYPE, ContentType.FORM_URLENCODED.toString())//头信息，多个头信息多次调用此方法即可
                .form(paramMap)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        System.out.println(result);
    }


    @Test(expected = IORuntimeException.class)
    public void postjson1() {
        User user = new User();
        user.setId(1);
        user.setName("long");
        user.setAge(30);
        user.setSex('M');

        Gson gson = new Gson();
        String json = gson.toJson(user);

        // Restful请求
        String result = HttpUtil.post(postJsonUrl, json);
        System.out.println(result);
    }

    @Test(expected = IORuntimeException.class)
    public void postjson2() {
        User user = new User();
        user.setId(1);
        user.setName("long");
        user.setAge(30);
        user.setSex('M');

        Gson gson = new Gson();
        String json = gson.toJson(user);

        // Restful请求
        String result = HttpRequest.post(postJsonUrl)
                .header(Header.CONTENT_TYPE, ContentType.JSON.toString())
                .body(json)
                .execute().body();
        System.out.println(result);
    }
}
