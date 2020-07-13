package com.zkzong.sj.repository;

import com.zkzong.sj.entity.Sharding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShardingRepository extends JpaRepository<Sharding, Long> {
    
}
