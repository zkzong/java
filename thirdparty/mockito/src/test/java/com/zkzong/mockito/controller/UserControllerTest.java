package com.zkzong.mockito.controller;

import com.zkzong.mockito.entity.User;
import com.zkzong.mockito.req.UserReq;
import com.zkzong.mockito.resp.UserResp;
import com.zkzong.mockito.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

/**
 * @Author: zong
 * @Date: 2021/7/5
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

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