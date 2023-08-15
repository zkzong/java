package com.example.sb2.repository;

import com.example.sb2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Zong
 * @Date: 2018/12/8
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
