package com.example.ss.repository;

import com.example.ss.entity.UserNoSharding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNoShardingRepository extends JpaRepository<UserNoSharding, Long> {
}
