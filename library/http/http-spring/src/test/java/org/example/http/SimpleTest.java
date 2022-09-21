package org.example.http;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zong on 2017/2/4.
 */
public class SimpleTest {
    private static final Log LOG = LogFactory.getLog(SimpleTest.class);

    public static final String URL = "http://127.0.0.1:8080/http/index2";

    @Test
    public void post() {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpRequest = HttpClients.createDefault();

        // 创建httppost
        HttpPost httppost = new HttpPost(URL);
        //---------设置超时时间---------
        /*RequestConfig config = RequestConfig.custom()
                                            .setSocketTimeout(5000)
                                            .setConnectTimeout(5000)
                                            .build();
        httppost.setConfig(config);*/
        //---------设置超时时间---------

        UrlEncodedFormEntity uefEntity;
        InputStream input = null;

        try {
            // 创建参数队列
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();

            formparams.add(new BasicNameValuePair("userName", "宗"));
            formparams.add(new BasicNameValuePair("userAge", "30"));
            formparams.add(new BasicNameValuePair("userSex", "男"));

            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            LOG.info("request: " + httppost.getURI());
            CloseableHttpResponse httpResponse = httpRequest.execute(httppost);
            try {
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    LOG.info("response: " + EntityUtils.toString(entity, "UTF-8"));
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                httpResponse.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            // 关闭输入流
            IOUtils.closeQuietly(input);

            // 关闭连接,释放资源
            if (httpRequest != null) {
                try {
                    httpRequest.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    @Test
    public void get() {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpRequest = HttpClients.createDefault();
        //---------设置超时时间---------
//        RequestConfig config = RequestConfig.custom()
//                                            .setSocketTimeout(20000)
//                                            .setConnectTimeout(20000)
//                                            .build();
//        httppost.setConfig(config);
        //---------设置超时时间---------

        InputStream input = null;
        HttpGet httpGet = null;
        try {
            // 创建参数队列
            List<NameValuePair> params = new ArrayList<NameValuePair>();

//            params.add(new BasicNameValuePair("appNo", "APPNO201304001"));
            params.add(new BasicNameValuePair("userName", "zong"));
            params.add(new BasicNameValuePair("userAge", "30"));
            params.add(new BasicNameValuePair("userSex", "nan"));

            String url = URLEncodedUtils.format(params, HTTP.UTF_8);
            url = URL + "?" + url;
            httpGet = new HttpGet(url);
//            httpGet.setHeader("Content-Type", "application/json;charset=utf-8");
            CloseableHttpResponse response = httpRequest.execute(httpGet);
            //{"data":{"response":{"nextLevelCitiesVersion":"1.0","dictionaryVersion":"1.0","allCitiesVersion":"1.0"}},"msg":"success","code":0}
            HttpEntity entity = response.getEntity();
//                if (entity != null) {
            System.out.println(EntityUtils.toString(entity, "UTF-8"));
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            // 关闭输入流
            IOUtils.closeQuietly(input);

            // 关闭连接,释放资源
            if (httpRequest != null) {
                try {
                    httpRequest.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
