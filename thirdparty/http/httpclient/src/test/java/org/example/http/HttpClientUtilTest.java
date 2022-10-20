package org.example.http;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
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

    //@Test
    //public void post() {
    //    try {
    //        HttpClient httpClient = new HttpClient();
    //        PostMethod postMethod = new PostMethod("http://localhost:8080/post");
    //        postMethod.setParameter("name", "zong");
    //        postMethod.setParameter("age", "30");
    //        // 发送请求
    //        httpClient.executeMethod(postMethod);
    //        // 发送状态
    //        Integer statusCode = postMethod.getStatusCode();
    //        // 发送成功
    //        result(statusCode, postMethod);
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}

    //@Test
    //public void postUser() {
    //    try {
    //        HttpClient httpClient = new HttpClient();
    //        PostMethod postMethod = new PostMethod("http://localhost:8080/postUser");
    //        Map<String, String> map = new HashMap<String, String>();
    //        map.put("name", "zong");
    //        map.put("age", "30");
    //        String userStr = JSON.toJSONString(map);
    //
    //        postMethod.setParameter("params", userStr);
    //        // 发送请求
    //        httpClient.executeMethod(postMethod);
    //        // 发送状态
    //        Integer statusCode = postMethod.getStatusCode();
    //        // 发送成功
    //        result(statusCode, postMethod);
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}

    //@Test
    //public void geta() {
    //    try {
    //        HttpClient httpClient = new HttpClient();
    //        GetMethod getMethod = new GetMethod("http://localhost:8080/get");
    //        // 不好使
    //        getMethod.getParams().setParameter("name", "zong");
    //        getMethod.getParams().setParameter("age", "30");
    //        // 发送请求
    //        httpClient.executeMethod(getMethod);
    //        // 发送状态
    //        Integer statusCode = getMethod.getStatusCode();
    //        // 发送成功
    //        result(statusCode, getMethod);
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}

    //@Test
    //public void getUser() {
    //    try {
    //        HttpClient httpClient = new HttpClient();
    //        String url = "http://localhost:8080/getUser";
    //        Map map = new HashMap<String, String>();
    //        map.put("name", "zong");
    //        map.put("age", "30");
    //        String userStr = JSON.toJSONString(map);
    //
    //        // 不好使
    //        GetMethod getMethod = new GetMethod(url + "?params = " + userStr);
    //
    //        // 发送请求
    //        httpClient.executeMethod(getMethod);
    //        // 发送状态
    //        Integer statusCode = getMethod.getStatusCode();
    //        // 发送成功
    //        result(statusCode, getMethod);
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}

    //private void result(Integer statusCode, HttpMethodBase method) throws IOException {
    //    if (statusCode != null && statusCode == HttpStatus.SC_OK) {
    //        System.out.println("http请求发送成功：" + statusCode);
    //        String response = method.getResponseBodyAsString();
    //        System.out.println(response);
    //    } else {
    //        System.out.println("http请求发送失败：" + statusCode);
    //    }
    //}

}