package com.example.hutool.http;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HttpTest {

    private String postUrl = "http://localhost:8080/post";
    private String postJsonUrl = "http://localhost:8080/post/json";

    @Test
    public void get() {
        //GET请求
        String content = HttpUtil.get("https://www.baidu.com");
        System.out.println(content);
    }

    @Test(expected = IORuntimeException.class)
    public void post1() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", "long");

        //POST请求
        String result = HttpUtil.post(postUrl, paramMap);
        System.out.println(result);
    }

    @Test(expected = IORuntimeException.class)
    public void post2() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", "long");

        //链式构建请求
        String result = HttpRequest.post(postUrl)
                .header(Header.CONTENT_TYPE, ContentType.FORM_URLENCODED.toString())//头信息，多个头信息多次调用此方法即可
                .form(paramMap)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        System.out.println(result);
    }


    @Test(expected = IORuntimeException.class)
    public void postjson1() {
        User user = new User();
        user.setId(1);
        user.setName("long");
        user.setAge(30);
        user.setSex('M');

        Gson gson = new Gson();
        String json = gson.toJson(user);

        // Restful请求
        String result = HttpUtil.post(postJsonUrl, json);
        System.out.println(result);
    }

    @Test(expected = IORuntimeException.class)
    public void postjson2() {
        User user = new User();
        user.setId(1);
        user.setName("long");
        user.setAge(30);
        user.setSex('M');

        Gson gson = new Gson();
        String json = gson.toJson(user);

        // Restful请求
        String result = HttpRequest.post(postJsonUrl)
                .header(Header.CONTENT_TYPE, ContentType.JSON.toString())
                .body(json)
                .execute().body();
        System.out.println(result);
    }

    @Test
    public void download() {
        // 下载文件，不需要鉴权
        long size = HttpUtil.downloadFile("https://img3.doubanio.com/view/subject/l/public/s33974633.jpg", new File("活着.jpg"));
        System.out.println(size);

        // 下载文件，需要鉴权
        size = HttpRequest.get("https://img3.doubanio.com/view/subject/l/public/s33974633.jpg")
                .basicAuth("username", "password")
                .timeout(1000)
                .execute().writeBody(new File("活着.jpg"));
        System.out.println(size);
    }

    @Test
    public void upload() {
        Map<String, Object> map = new HashMap<>();
        String path = this.getClass().getClassLoader().getResource("").getPath();
        File file = new File(path + "/aaa.pdf");
        map.put("file", file);
        String body = HttpRequest.post("http://localhost:8080/http/upload")
                .form(map)
                .execute().body();
        System.out.println(body);

        body = HttpRequest.post("http://localhost:8080/http/upload")
                .form("file", file)
                .execute().body();
        System.out.println(body);
    }
}
