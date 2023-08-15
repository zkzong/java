package com.example.sb2.pojo;

import lombok.Data;

/**
 * @Author: zong
 * @Date: 2022/3/20
 */
@Data
public class TokenInfo {
    /**
     * token类型: api:0 、user:1
     */
    private Integer tokenType;

    /**
     * App 信息
     */
    private AppInfo appInfo;

    /**
     * 用户其他数据
     */
    private UserInfo userInfo;
}
