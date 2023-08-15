package com.example.sb2.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JsonFieldClass {

    @JSONField(name = "userName")
    private String name;

    private Integer age;

    private Integer sex;

}
