package org.example.http.util;

import com.alibaba.fastjson.JSON;
import org.example.http.pojo.User;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zong
 * @Date: 2019.1.17
 */
public class HttpClientUtilTest {

    @Test
    public void get() {
        String url = "http://127.0.0.1";
        HttpClientUtil.get(url);
    }

    @Test
    public void postForm() {
        String url = "http://127.0.0.1:8080/http/form";
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        nameValuePairList.add(new BasicNameValuePair("userName", "zong"));
        nameValuePairList.add(new BasicNameValuePair("age", "30"));
        HttpClientUtil.postForm(url, nameValuePairList);
    }

    @Test
    public void postJson() {
        String url = "http://127.0.0.1:8080/http/json";
        User user = new User();
        user.setUserName("zong");
        user.setAge(20);
        String userStr = JSON.toJSONString(user);
        HttpClientUtil.postJson(url, userStr);
    }
}