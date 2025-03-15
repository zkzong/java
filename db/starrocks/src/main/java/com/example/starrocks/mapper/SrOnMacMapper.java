package com.example.starrocks.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.starrocks.entity.SrOnMac;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface SrOnMacMapper extends BaseMapper<SrOnMac> {

    @Insert("insert into sr_on_mac(c0, c1, c2, c3) values(#{c0}, #{c1}, #{c2}, #{c3})")
    int insertOne(@Param("c0") Long name, @Param("c1") String c1, @Param("c2") String c2, @Param("c3") String c3);

}
