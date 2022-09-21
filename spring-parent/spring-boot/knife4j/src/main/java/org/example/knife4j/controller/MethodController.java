/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package org.example.knife4j.controller;

import org.example.knife4j.common.RestMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2018/07/18 14:28
 */
@Api(value = "多方法", tags = "相同URL")
@RequestMapping("/api/methods")
@RestController
public class MethodController {


    @ApiOperation(value = "相同url,不同method", notes = "针对相同url，不同mehtod类型未展示bug")
    @RequestMapping(value = "/allMethod")
    public RestMessage allMethod() {
        RestMessage r = new RestMessage();
        r.setData("针对相同url，不同mehtod类型未展示bug");
        return r;
    }

}
