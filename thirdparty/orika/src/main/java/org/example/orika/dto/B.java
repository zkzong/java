package org.example.orika.dto;

import lombok.Data;

/**
 * @Author: zong
 * @Date: 2019.3.25
 */
@Data
public class B {
    private String name;

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                '}';
    }
}
