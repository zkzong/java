package com.zkzong.sb.swagger2.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Administrator on 2017/7/3.
 */
@Data
public class Person {
    @ApiModelProperty(value = "主键", position = 1)
    private Long id;
    @ApiModelProperty(value = "姓名", position = 2)
    private String name;
    @ApiModelProperty(value = "年龄", position = 3)
    private Integer age;
}
