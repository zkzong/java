package com.zkzong.powermock.controller;

import com.zkzong.powermock.entity.User;
import com.zkzong.powermock.req.UserReq;
import com.zkzong.powermock.resp.UserResp;
import com.zkzong.powermock.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

/**
 * @Author: zong
 * @Date: 2021/7/5
 */
@RunWith(PowerMockRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    /**
     * 必须mock service，否则报空指针
     */
    @Mock
    private UserService userService;

    @Test
    public void insert() {
        UserReq req = new UserReq();
        req.setUserName("liu");
        req.setAge(3);
        req.setAddress("sh");
        UserResp resp = userController.insert(req);
        Assert.assertEquals("0000", resp.getCode());
        Assert.assertEquals("SUCCESS", resp.getMsg());
    }

    @Test
    public void getUser() {
        UserResp<List<User>> resp = userController.getUser("zong");
        Assert.assertEquals("0000", resp.getCode());
        Assert.assertEquals("SUCCESS", resp.getMsg());
    }

    @Test
    public void queryUser() {
        UserReq req = new UserReq();
        req.setUserName("zong");
        UserResp<List<User>> resp = userController.queryUser(req);
        Assert.assertEquals("0000", resp.getCode());
        Assert.assertEquals("SUCCESS", resp.getMsg());
    }
}