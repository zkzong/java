package com.zkzong.http;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpTest {

    @Test
    public void post() {
        try {
            HttpClient httpClient = new HttpClient();
            PostMethod postMethod = new PostMethod("http://localhost:8080/post");
            postMethod.setParameter("name", "zong");
            postMethod.setParameter("age", "30");
            // 发送请求
            httpClient.executeMethod(postMethod);
            // 发送状态
            Integer statusCode = postMethod.getStatusCode();
            // 发送成功
            result(statusCode, postMethod);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void postUser() {
        try {
            HttpClient httpClient = new HttpClient();
            PostMethod postMethod = new PostMethod("http://localhost:8080/postUser");
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", "zong");
            map.put("age", "30");
            String userStr = JSON.toJSONString(map);

            postMethod.setParameter("params", userStr);
            // 发送请求
            httpClient.executeMethod(postMethod);
            // 发送状态
            Integer statusCode = postMethod.getStatusCode();
            // 发送成功
            result(statusCode, postMethod);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get() {
        try {
            HttpClient httpClient = new HttpClient();
            GetMethod getMethod = new GetMethod("http://localhost:8080/get");
            // 不好使
            getMethod.getParams().setParameter("name", "zong");
            getMethod.getParams().setParameter("age", "30");
            // 发送请求
            httpClient.executeMethod(getMethod);
            // 发送状态
            Integer statusCode = getMethod.getStatusCode();
            // 发送成功
            result(statusCode, getMethod);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUser() {
        try {
            HttpClient httpClient = new HttpClient();
            String url = "http://localhost:8080/getUser";
            Map map = new HashMap<String, String>();
            map.put("name", "zong");
            map.put("age", "30");
            String userStr = JSON.toJSONString(map);

            // 不好使
            GetMethod getMethod = new GetMethod(url + "?params = " + userStr);

            // 发送请求
            httpClient.executeMethod(getMethod);
            // 发送状态
            Integer statusCode = getMethod.getStatusCode();
            // 发送成功
            result(statusCode, getMethod);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void result(Integer statusCode, HttpMethodBase method) throws IOException {
        if (statusCode != null && statusCode == HttpStatus.SC_OK) {
            System.out.println("http请求发送成功：" + statusCode);
            String response = method.getResponseBodyAsString();
            System.out.println(response);
        } else {
            System.out.println("http请求发送失败：" + statusCode);
        }
    }
}
