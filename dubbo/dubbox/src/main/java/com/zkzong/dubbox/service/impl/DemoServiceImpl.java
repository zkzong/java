package com.zkzong.dubbox.service.impl;

import com.zkzong.dubbox.service.DemoService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created by Zong on 2017/3/30.
 */
@Path("demo")
public class DemoServiceImpl implements DemoService {

    @GET
    @Path("greeting")
    @Produces("application/json; charset=UTF-8")
    @Override
    public String sayHello(@QueryParam("name") String name) {
        return "Hello" + name;
    }
}
