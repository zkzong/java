package org.example.http;

import org.example.http.util.HttpClientUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * HttpClient测试
 */
public class TestHttpClient {
    public static void main(String[] args) {
        try {
            HttpClientUtils.get("http://localhost:8080/http/index?name=zhangsan&age=22&sex=nan");

            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            parameters.add(new BasicNameValuePair("name", "zhangsan"));
            parameters.add(new BasicNameValuePair("age", "22"));
            parameters.add(new BasicNameValuePair("sex", "nan"));
            HttpClientUtils.post("http://localhost:8080/http/index", parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
