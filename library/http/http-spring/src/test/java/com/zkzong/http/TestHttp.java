package com.zkzong.http;

import com.zkzong.http.util.HttpClientUtil;
import com.zkzong.http.util.HttpUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http通信测试
 */
public class TestHttp {
    public static void main(String[] args) {
        try {
            // --------------测试请求/test/index begin---------------------------
//            HttpUtil.get("http://localhost:8080/http/index?name=zhangsan&age=22&sex=nan");
//
//            Map<String, String> parameterMap = new HashMap<String, String>();
//            parameterMap.put("name", "zhangsan");
//            parameterMap.put("age", "22");
//            parameterMap.put("sex", "nan");
//            HttpUtil.post("http://localhost:8080/http/index", parameterMap);
//
//            HttpClientUtil
//                    .httpclientGet("http://localhost:8080/http/index?name=zhangsan&age=22&sex=nan");
//
//            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
//            parameters.add(new BasicNameValuePair("name", "zhangsan"));
//            parameters.add(new BasicNameValuePair("age", "22"));
//            parameters.add(new BasicNameValuePair("sex", "nan"));
//            HttpClientUtil.httpclientPost("http://localhost:8080/http/index", parameters);
            // --------------测试请求/test/index end---------------------------

            // --------------测试请求/test/index2 begin---------------------------
            HttpUtil.get("http://localhost:8080/http/index2?userName=zhangsan&userAge=22&userSex=nan");

            Map<String, String> parameterMap = new HashMap<String, String>();
            parameterMap.put("userName", "zhangsan");
            parameterMap.put("userAge", "22");
            parameterMap.put("userSex", "nan");
            HttpUtil.post("http://localhost:8080/http/index2", parameterMap);

            HttpClientUtil
                    .httpclientGet("http://localhost:8080/http/index2?userName=zhangsan&userAge=22&userSex=nan");

            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            parameters.add(new BasicNameValuePair("userName", "zhangsan"));
            parameters.add(new BasicNameValuePair("userAge", "22"));
            parameters.add(new BasicNameValuePair("userSex", "nan"));
            HttpClientUtil.httpclientPost("http://localhost:8080/http/index2", parameters);
            // --------------测试请求/test/index2 end---------------------------
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
