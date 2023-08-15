package com.example.sb2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zong
 * @Date: 2022/3/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppInfo {
    /**
     * App id
     */
    private String appId;
    /**
     * API 秘钥
     */
    private String key;
}

