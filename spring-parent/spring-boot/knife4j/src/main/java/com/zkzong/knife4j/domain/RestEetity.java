/*
 * Copyright (C) 2017 Zhejiang BYCDAO Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.bycdao.com.
 * Developer Web Site: http://open.bycdao.com.
 */

package com.zkzong.knife4j.domain;

import io.swagger.annotations.ApiModelProperty;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2017/08/21 15:49
 */
public class RestEetity {

    @ApiModelProperty("编码")
    private String code;

    private ReqEntity reqEntity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ReqEntity getReqEntity() {
        return reqEntity;
    }

    public void setReqEntity(ReqEntity reqEntity) {
        this.reqEntity = reqEntity;
    }
}
