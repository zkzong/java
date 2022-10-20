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
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @Author: zong
 * @Date: 2019.1.17
 */
public class HttpClientUtil {

    /**
     * 发送get请求
     */
    public static void get(String url, String params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget
            HttpGet httpget = new HttpGet(url + "?" + params);
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

    /**
     * 上传文件
     */
    public static void upload(String url) {
        // 创建默认的httpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httpPost = new HttpPost(url);

        File file = new File("/Users/admin/baidu.png");
        FileBody fileBody = new FileBody(file);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("file", fileBody);
        HttpEntity httpEntity = builder.build();
        httpPost.setEntity(httpEntity);

        try {
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
     * 使用URLConnection实现GET请求
     * <p>
     * 1.实例化一个java.net.URL对象；
     * 2.通过URL对象的openConnection()方法得到一个java.net.URLConnection;
     * 3.通过URLConnection对象的getInputStream()方法获得输入流；
     * 4.读取输入流；
     * 5.关闭资源；
     */
    public static void getURLConnection(String urlStr) throws Exception {

        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection(); // 打开连接

        System.out.println(urlConnection.getURL().toString());

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8")); // 获取输入流
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        System.out.println(sb.toString());
    }

    /**
     * 使用HttpURLConnection实现POST请求
     * <p>
     * 1.实例化一个java.net.URL对象；
     * 2.通过URL对象的openConnection()方法得到一个java.net.URLConnection;
     * 3.通过URLConnection对象的getOutputStream()方法获得输出流；
     * 4.向输出流中写数据；
     * 5.关闭资源；
     */
    public static void postURLConnection(String urlStr, Map<String, String> parameterMap) throws IOException {

        URL url = new URL(urlStr);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true); // 设置该连接是可以输出的
        httpURLConnection.setRequestMethod("POST"); // 设置请求方式
        httpURLConnection.setRequestProperty("charset", "utf-8");

        System.out.println(httpURLConnection.getURL().toString());

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(httpURLConnection.getOutputStream()));

        StringBuffer parameter = new StringBuffer();
        parameter.append("1=1");
        for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
            parameter.append("&" + entry.getKey() + "=" + entry.getValue());
        }
        pw.write(parameter.toString());// 向连接中写数据（相当于发送数据给服务器）

        pw.flush();
        pw.close();

        System.out.println("parameter: " + parameter.toString());

        BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) { // 读取数据
            sb.append(line + "\n");
        }
        br.close();
        System.out.println(sb.toString());
    }

}
