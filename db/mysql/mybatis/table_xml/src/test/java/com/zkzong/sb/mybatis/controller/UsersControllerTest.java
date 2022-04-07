package com.zkzong.sb.mybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.zkzong.sb.mybatis.domain.Users;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsersControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        // 初始化 MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void insert() throws Exception {
        Users users = new Users();
        users.setUserName("ma");
        users.setAge(20);
        String json = JSONObject.toJSONString(users);

        // 调用获取 Token 接口
        String post = mockMvc.perform(MockMvcRequestBuilders.post("/users/insert")
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andReturn()
                .getResponse().getContentAsString();
        log.info("获取的 Token 串：{}", post);
    }

    @Test
    public void getAllUsers() throws Exception {
        // 调用获取 Token 接口
        String get = mockMvc.perform(MockMvcRequestBuilders.get("/users/getAll")
                        .accept(MediaType.ALL))
                .andExpect(status().isOk()).andDo(print())
                .andReturn()
                .getResponse().getContentAsString();
        log.info("获取的 Token 串：{}", get);
    }
}