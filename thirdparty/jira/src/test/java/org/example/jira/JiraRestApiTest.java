package org.example.jira;

import cn.hutool.http.HttpRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @Author: zongz
 * @Date: 2024-11-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JiraRestApiTest {

    @Test
    public void insight() {
        String body = HttpRequest.get("https://jira.com/rest/insight/1.0/iql/objects?iql=ObjectType=Serie")
                .basicAuth("username", "password")
                //.header(Header.CONTENT_TYPE, ContentType.OCTET_STREAM.toString())
                .timeout(1000)
                .execute().body();
        System.out.println(body);
    }

    @Test
    public void file() {
        long body = HttpRequest.get("https://jira.com/secure/attachment/1635409/AccessClient.exe")
                .basicAuth("username", "password")
                //.header(Header.CONTENT_TYPE, ContentType.OCTET_STREAM.toString())
                .timeout(1000)
                .execute().writeBody(new File("AccessClient.exe"));
        System.out.println(body);
    }

}
