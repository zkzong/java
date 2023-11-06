package com.example.sb2.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JsonFieldClass {

    @JSONField(name = "userName")
    @JsonProperty("username")
    private String name;

    private Integer age;

    private Integer sex;

}
