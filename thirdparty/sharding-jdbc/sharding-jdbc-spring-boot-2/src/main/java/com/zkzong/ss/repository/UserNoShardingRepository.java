package com.zkzong.ss.repository;

import com.zkzong.ss.entity.UserNoSharding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNoShardingRepository extends JpaRepository<UserNoSharding, Long> {
}
