package com.zkzong.sb2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author: zong
 * @Date: 2020/1/11
 */
@Data
public class JsonRootBean {

    @JsonProperty(value = "Request")
    private Request request;

    public void setRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

}
