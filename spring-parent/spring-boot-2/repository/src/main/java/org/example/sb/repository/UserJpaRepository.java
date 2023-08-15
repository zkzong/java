package com.example.sb.repository;

import com.example.sb.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}
