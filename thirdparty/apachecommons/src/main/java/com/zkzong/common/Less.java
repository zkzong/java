package com.zkzong.common;

import lombok.Data;

/**
 * Created by zong on 2017/2/24.
 */
@Data
public class Less {
    private Integer id;
    private String name;
    private Integer sex;

    public Less() {
    }

    public Less(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
