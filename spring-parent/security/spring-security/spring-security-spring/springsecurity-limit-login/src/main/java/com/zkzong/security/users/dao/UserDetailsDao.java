package com.zkzong.security.users.dao;

import com.zkzong.security.users.model.UserAttempts;

/**
 * Created by Zong on 2017/5/20.
 */
public interface UserDetailsDao {
    void updateFailAttempts(String username);

    void resetFailAttempts(String username);

    UserAttempts getUserAttempts(String username);
}
