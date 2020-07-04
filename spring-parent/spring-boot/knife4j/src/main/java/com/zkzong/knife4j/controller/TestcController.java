/*
 * Copyright (C) 2017 Zhejiang BYCDAO Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.bycdao.com.
 * Developer Web Site: http://open.bycdao.com.
 */

package com.zkzong.knife4j.controller;

import com.google.common.collect.ImmutableMap;
import com.zkzong.knife4j.common.Rest;
import com.zkzong.knife4j.common.RestMessage;
import com.zkzong.knife4j.domain.ReqEntity;
import com.zkzong.knife4j.domain.RestEetity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2017/08/10 14:47
 */
@Api(value = "测试路径", tags = "测试路径")
@RequestMapping("/api/testc")
@RestController
public class TestcController {

    @PostMapping("/selectLog")
    @ApiOperation(value = "RequestBody接收Map参数", notes = "RequestBody接收Map参数")
    public RestMessage selectLog(@RequestBody Map<String, Object> infoMap,
                                 @RequestAttribute(name = "CURRENTUSERID") int userId) {
        return new RestMessage(infoMap);
    }

    @PostMapping("/examp1")
    @ApiOperation(value = "ModelAttribute接收实体类参数", notes = "ModelAttribute接收实体类参数,非RequestBody的情况")
    public RestMessage reqbody1(ReqEntity reqEntity) {
        return new RestMessage(reqEntity);
    }

    @PostMapping("/select1")
    @ApiOperation(value = "请求头Header参数", notes = "请求头Header参数")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "code", name = "code", dataType = "string"),
            @ApiImplicitParam(value = "headerparam", name = "headerparam", dataType = "string"),
            @ApiImplicitParam(value = "page", name = "page", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "page1", name = "page1", dataType = "Long", paramType = "query")
    })
    public RestMessage reqbody3(@RequestHeader(value = "headerparam") String headerparam, @RequestParam(value = "code") String code,
                                @RequestParam(value = "page") int page, @RequestParam(value = "page1") Long page1) {
        return new RestMessage(ImmutableMap.of("code", code, "header", headerparam, "page", page, "page1", page1));
    }

    @DeleteMapping(value = "/xdf/{code}")
    @ApiImplicitParams({@ApiImplicitParam(value = "code", name = "code", dataType = "Long", paramType = "path")})
    @ApiOperation(value = "PathVariable路径请求", notes = "PathVariable路径请求")
    public RestMessage urlpath(@PathVariable(value = "code") Long code) {
        return new RestMessage(code);
    }

    @ApiOperation(value = "响应泛型对象", notes = "响应泛型对象")
    @GetMapping("/rest")
    public Rest<ReqEntity> rest() {
        ReqEntity reqEntity = new ReqEntity();
        reqEntity.setName("张飞");
        reqEntity.setTel("13093939102");
        Rest<ReqEntity> restEetity = new Rest<>();
        restEetity.setData(reqEntity);
        return restEetity;
    }

    @GetMapping("/resp")
    @ApiOperation(value = "响应一般对象", notes = "响应一般对象")
    public RestEetity resp() {
        ReqEntity reqEntity = new ReqEntity();
        reqEntity.setName("张飞");
        reqEntity.setTel("13093939102");
        RestEetity restEetity = new RestEetity();
        restEetity.setReqEntity(reqEntity);
        return restEetity;
    }
}
