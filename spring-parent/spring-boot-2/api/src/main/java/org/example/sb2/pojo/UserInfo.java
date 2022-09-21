package org.example.sb2.pojo;

import lombok.Data;

/**
 * @Author: zong
 * @Date: 2022/3/20
 */
@Data
public class UserInfo {
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;

    private AccessToken accessToken;

    public UserInfo(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }
}
