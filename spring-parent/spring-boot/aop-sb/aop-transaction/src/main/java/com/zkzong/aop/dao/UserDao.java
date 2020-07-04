package com.zkzong.aop.dao;

import com.zkzong.aop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
