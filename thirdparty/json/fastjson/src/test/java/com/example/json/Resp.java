package com.example.json;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Resp<T> implements Serializable {

    private String code;
    private String msg;
    @JSONField(alternateNames = {"Data", "Datas"})
    private T data;
}
