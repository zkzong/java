package com.zkzong.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class TestHttpWithJSON {

    public static void httpPostWithJSON(String url, String json) {
        // 创建默认的httpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httppost
            HttpPost httppost = new HttpPost(url);
            httppost.addHeader("Content-type", "application/json; charset=utf-8");
            System.out.println("executing request " + httppost.getURI());

            // 向POST请求中添加消息实体
            StringEntity se = new StringEntity(json, "UTF-8");
            httppost.setEntity(se);
            System.out.println("request parameters " + json);

            // 执行post请求
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容
                    System.out.println("--------------------------------------");
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            System.out.println("executing httpPostWithJSON error: " + e.getMessage());
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                System.out.println("executing httpPostWithJSON error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
//         JsonObject jsonObject = new JsonObject();
//         jsonObject.addProperty("userName", "张三");
//         jsonObject.addProperty("userAge", "22");
//         jsonObject.addProperty("userSex", "男");
//         String url = "http://localhost:8080/http/index3";
//        System.out.println(jsonObject.toString());
//         httpPostWithJSON(url, jsonObject.toString());

        String url = "http://localhost:8080/http/index3";
        String json = "{\"userName\":\"张三\",\"userAge\":\"22\",\"userSex\":\"男\"}";
        httpPostWithJSON(url, json);
    }
}
