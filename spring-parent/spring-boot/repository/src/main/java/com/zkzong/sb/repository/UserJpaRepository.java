package com.zkzong.sb.repository;

import com.zkzong.sb.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}
