package com.zkzong.dubbo.web.service;

import com.zkzong.dubbo.web.entity.User;

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
public interface UserService {
    @GET
    @Path("{name}")
    User queryUserByName(@PathParam("name") String name);
}
