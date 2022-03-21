package com.zkzong.sb2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author: zong
 * @Date: 2022/3/20
 */
@Data
@AllArgsConstructor
public class AccessToken {
    /**
     * token
     */
    private String token;

    /**
     * 失效时间
     */
    private Date expireTime;
}
