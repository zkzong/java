/*
 * Copyright (C) 2017 Zhejiang BYCDAO Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.BYCDAO.com.
 * Developer Web Site: http://open.BYCDAO.com.
 */

package com.zkzong.knife4j.controller;

import com.zkzong.knife4j.common.Rest;
import com.zkzong.knife4j.domain.Menu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2017/08/10 14:14
 */
@Api(value = "菜单信息", tags = "菜单信息")
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @PostMapping("/getMenu")
    @ApiOperation(value = "递归获取菜单", notes = "获取菜单,考虑递归的情况")
    public Menu getMenu() {
        Menu menu = new Menu("caidan_system", "菜单系统");

        menu.addChildren(new Menu("label1", "菜单1"));
        menu.addChildren(new Menu("label2", "菜单2"));
        menu.addChildren(new Menu("label3", "菜单3"));
        menu.addChildren(new Menu("label4", "菜单4"));
        return menu;
    }

    @PostMapping("/getRestMenu")
    @ApiOperation(value = "响应泛型为菜单Menu对象", notes = "获取菜单,考虑递归的情况")
    public Rest<Menu> getRestMenu() {
        Menu menu = new Menu("caidan_system", "菜单系统");

        menu.addChildren(new Menu("label1", "菜单1"));
        menu.addChildren(new Menu("label2", "菜单2"));
        menu.addChildren(new Menu("label3", "菜单3"));
        menu.addChildren(new Menu("label4", "菜单4"));

        Rest<Menu> rest = new Rest<>();
        rest.setData(menu);
        return rest;
    }
}
