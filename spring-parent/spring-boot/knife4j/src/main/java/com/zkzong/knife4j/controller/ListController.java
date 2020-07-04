/*
 * Copyright (C) 2017 Zhejiang lishiots Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.lishiots.com.
 * Developer Web Site: http://open.lishiots.com.
 */

package com.zkzong.knife4j.controller;

import com.zkzong.knife4j.common.Rest;
import com.zkzong.knife4j.common.RestMessage;
import com.zkzong.knife4j.domain.ReqEntity;
import com.zkzong.knife4j.domain.WorkExperience;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/01/19 11:05
 */
@Api(value = "列表展示", tags = "列表展示")
@RestController
@RequestMapping("/api/list")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误", response = RestMessage.class)})
public class ListController {

    @PostMapping("/query1")
    @ApiOperation(value = "场馆列表", notes = "获取场馆列表", responseContainer = "List", response = ReqEntity.class)
    public List<ReqEntity> query1(@RequestBody List<WorkExperience> workExperiences) {
        List<ReqEntity> list = new ArrayList<>();
        list.add(new ReqEntity());
        return list;
    }


    @PostMapping("/query")
    @ApiOperation(value = "场馆列表", notes = "获取场馆列表", responseContainer = "List", response = ReqEntity.class)
    public List<ReqEntity> query() {
        List<ReqEntity> list = new ArrayList<>();
        list.add(new ReqEntity());
        return list;
    }

    @PostMapping("/obj")
    public Rest<ReqEntity> obj() {
        ReqEntity reqEntity = new ReqEntity();
        Rest<ReqEntity> reqEntityRest = new Rest<>();
        reqEntityRest.setData(reqEntity);
        return reqEntityRest;
    }

    @PostMapping("/objList")
    public List<Rest<ReqEntity>> objList() {
        List<Rest<ReqEntity>> list = new ArrayList<>();
        ReqEntity reqEntity = new ReqEntity();
        Rest<ReqEntity> reqEntityRest = new Rest<>();
        reqEntityRest.setData(reqEntity);
        list.add(reqEntityRest);
        return list;
    }
}
