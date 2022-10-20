package org.example.http;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.example.http.entity.User;
import org.example.http.util.HttpClientUtil;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String url = "http://127.0.0.1:8080/http/post/json";
        User user = new User();
        user.setUsername("zong");
        user.setAge(20);
        String userStr = JSON.toJSONString(user);
        HttpClientUtil.postJson(url, userStr);
    }

}