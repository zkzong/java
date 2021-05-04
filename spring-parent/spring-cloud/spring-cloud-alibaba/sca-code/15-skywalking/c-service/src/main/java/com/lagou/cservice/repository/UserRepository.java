package com.lagou.cservice.repository;

import com.lagou.cservice.entiey.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM user" , nativeQuery = true)
    public List<User> selectAll();
}
