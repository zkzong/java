package org.example.clickhouse.service;

import org.example.clickhouse.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void saveData() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(0);
        userInfo.setUserName("zong");
        userInfo.setPassWord("zong");
        userInfo.setPhone("12345678900");
        userInfo.setEmail("zong@163.com");
        userInfo.setCreateDay("2022-10-10");
        userInfoService.saveData(userInfo);
    }

    @Test
    public void selectById() {
        UserInfo userInfo = userInfoService.selectById(1);
        System.out.println(userInfo);
    }

    @Test
    public void selectList() {
        List<UserInfo> userInfos = userInfoService.selectList();
        System.out.println(userInfos);
    }
}