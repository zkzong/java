package org.example.sb.transaction.service;

import org.example.sb.transaction.domain.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Zong on 2017/5/27.
 */
public interface UserService {

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    User login(String name, String password);
}
