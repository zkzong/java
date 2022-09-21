package org.example.mockito.controller;

import org.example.mockito.entity.User;
import org.example.mockito.req.UserReq;
import org.example.mockito.resp.UserResp;
import org.example.mockito.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

/**
 * @Author: zong
 * @Date: 2021/7/5
 */
@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class UserControllerTest {

    //private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    /**
     * 必须mock service，否则报空指针
     */
    @Mock
    private UserService userService;

    //@Before
    //public void before() {
    //    mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    //}

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