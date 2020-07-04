package com.zkzong.sb.shiro.sevice;

import com.zkzong.sb.shiro.entity.UserInfo;

public interface UserInfoService {
    /**
     * 通过username查找用户信息;
     */
    public UserInfo findByUsername(String username);
}