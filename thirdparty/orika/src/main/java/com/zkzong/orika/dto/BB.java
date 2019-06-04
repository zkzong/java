package com.zkzong.orika.dto;

import lombok.Data;

/**
 * @Author: zong
 * @Date: 2019.3.25
 */
@Data
public class BB extends B {
    private Integer age;

    @Override
    public String toString() {
        return "BB{" +
                "age=" + age +
                '}';
    }
}
