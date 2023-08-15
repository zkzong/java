package com.example.http;

import com.alibaba.fastjson.JSON;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.example.http.entity.User;
import com.example.http.util.HttpClientUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zong
 * @Date: 2019.1.17
 */
public class HttpClientUtilTest {

    private String url = "http://127.0.0.1:8080";

    @Test
    public void getnull() {
        url += "/http/get";
        HttpClientUtil.get(url, null);
    }

    @Test
    public void get() {
        url += "/http/get";
        String params = "username=zong&age=10";
        HttpClientUtil.get(url, params);
    }

    @Test
    public void getUser() {
        url += "/http/getUser";
        String params = "params={\"username\":\"zong\",\"age\":30}";
        HttpClientUtil.get(url, params);
    }

    @Test
    public void postForm() {
        url += "/http/post/form";
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        nameValuePairList.add(new BasicNameValuePair("username", "zong"));
        nameValuePairList.add(new BasicNameValuePair("age", "30"));
        HttpClientUtil.postForm(url, nameValuePairList);
    }

    @Test
    public void postJson() {
        url += "/http/post/json";
        User user = new User();
        user.setUsername("zong");
        user.setAge(20);
        String userStr = JSON.toJSONString(user);
        HttpClientUtil.postJson(url, userStr);
    }

    @Test
    public void upload() {
        url += "/http/upload";
        HttpClientUtil.upload(url);
    }

}