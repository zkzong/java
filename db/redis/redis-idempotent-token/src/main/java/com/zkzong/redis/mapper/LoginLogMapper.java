package com.zkzong.redis.mapper;

import com.zkzong.redis.pojo.LoginLog;

public interface LoginLogMapper {

    void insert(LoginLog loginLog);

    LoginLog selectByMsgId(String msgId);

}
