package com.zkzong.sj.repository;

import com.zkzong.sj.entity.Sharding;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShardingRepository {

    Long insert(Sharding sharding);

}
