package org.example.http.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;

public class HttpClientUtil {
    /**
     * 使用httpclient进行http通信
     * <p>
     * Get请求
     */
    public static void httpclientGet(String urlStr) throws Exception {

        System.out.println(urlStr);

        // 创建HttpClient对象
        HttpClient client = HttpClients.createDefault();

        // 创建GET请求（在构造器中传入URL字符串即可）
        HttpGet get = new HttpGet(urlStr);

        // 调用HttpClient对象的execute方法获得响应
        HttpResponse response = client.execute(get);

        // 调用HttpResponse对象的getEntity方法得到响应实体
        HttpEntity httpEntity = response.getEntity();

        // 使用EntityUtils工具类得到响应的字符串表示
        String result = EntityUtils.toString(httpEntity, "utf-8");
        System.out.println(result);
    }

    /**
     * 使用httpclient进行http通信
     * <p>
     * Post请求
     */
    public static void httpclientPost(String urlStr, List<NameValuePair> parameters) throws Exception {

        System.out.println(urlStr);

        // 创建HttpClient对象
        HttpClient client = HttpClients.createDefault();

        // 创建POST请求
        HttpPost post = new HttpPost(urlStr);

        // 创建一个List容器，用于存放基本键值对（基本键值对即：参数名-参数值）--> parameters

        // 向POST请求中添加消息实体
        post.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));

        // 得到响应并转化成字符串
        HttpResponse response = client.execute(post);
        HttpEntity httpEntity = response.getEntity();
        String result = EntityUtils.toString(httpEntity, "utf-8");
        System.out.println(result);
    }
}
