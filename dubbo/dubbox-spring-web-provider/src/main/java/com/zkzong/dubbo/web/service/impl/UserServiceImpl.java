package com.zkzong.dubbo.web.service.impl;

import com.zkzong.dubbo.web.entity.User;
import com.zkzong.dubbo.web.service.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Zong on 2017/3/30.
 */
@Path("user")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class UserServiceImpl implements UserService {
    @GET
    @Path("{name}")
    public User queryUserByName(@PathParam("name") String name) {
        User user = new User();
        user.setName("zong");
        user.setAge(20);
        user.setAddress("henan");
        return user;
    }
}
