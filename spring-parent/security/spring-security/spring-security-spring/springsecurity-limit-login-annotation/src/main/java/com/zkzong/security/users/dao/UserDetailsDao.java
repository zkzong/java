package com.zkzong.security.users.dao;

import com.zkzong.security.users.model.UserAttempts;

public interface UserDetailsDao {

    void updateFailAttempts(String username);

    void resetFailAttempts(String username);

    UserAttempts getUserAttempts(String username);

}