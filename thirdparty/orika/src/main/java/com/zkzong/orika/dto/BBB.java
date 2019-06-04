package com.zkzong.orika.dto;

import lombok.Data;

/**
 * @Author: zong
 * @Date: 2019.3.25
 */
@Data
public class BBB extends BB {
    private String birthDay;

    @Override
    public String toString() {
        return "BBB{" +
                "birthDay=" + birthDay +
                '}';
    }
}
