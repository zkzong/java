package com.zkzong.hutool.http;

import cn.hutool.http.HttpUtil;
import org.junit.Test;

import java.util.HashMap;

public class HttpTest {

    @Test
    public void get() {
        //GET请求
        String content = HttpUtil.get("https://www.baidu.com/s?wd=java");
        System.out.println(content);
    }

    @Test
    public void post() {
        //POST请求
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");

        String result = HttpUtil.post("https://www.baidu.com", paramMap);
        System.out.println(result);
    }
}
