package org.example.http.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Author: zong
 * @Date: 2019.1.17
 */
public class HttpClientUtil {

    /**
     * 发送get请求
     */
    public static void get(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget
            HttpGet httpget = new HttpGet(url);
            System.out.println("executing request " + httpget.getURI());
            // 执行get请求
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    System.out.println("Response content: " + EntityUtils.toString(entity));
                }
                System.out.println("------------------------------------");
            } finally {
                HttpClientUtils.closeQuietly(response);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            HttpClientUtils.closeQuietly(httpclient);

        }
    }

    /**
     * 发送post请求
     */
    public static void postForm(String url, List<NameValuePair> formparams) {
        // 创建默认的httpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httpPost = new HttpPost(url);
        // 创建参数队列 --> formparams
        UrlEncodedFormEntity uefEntity;
        try {
            // 向POST请求中添加消息实体
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httpPost.setEntity(uefEntity);
            System.out.println("executing request " + httpPost.getURI());
            // 执行post请求
            CloseableHttpResponse response = httpclient.execute(httpPost);
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
                HttpClientUtils.closeQuietly(response);
                httpPost.releaseConnection();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            HttpClientUtils.closeQuietly(httpclient);
        }
    }

    /**
     * 发送post请求
     */
    public static void postJson(String url, String json) {
        // 创建默认的httpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        // 创建参数队列 --> formparams
        StringEntity stringEntity;
        try {
            // 向POST请求中添加消息实体
            stringEntity = new StringEntity(json, "UTF-8");
            httpPost.setEntity(stringEntity);
            System.out.println("executing request " + httpPost.getURI());
            // 执行post请求
            CloseableHttpResponse response = httpclient.execute(httpPost);
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
                HttpClientUtils.closeQuietly(response);
                httpPost.releaseConnection();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            HttpClientUtils.closeQuietly(httpclient);
        }
    }

}
