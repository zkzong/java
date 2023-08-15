package com.example.clickhouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.example.clickhouse.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    // 写入数据
    void saveData(UserInfo userInfo);

    // ID 查询
    UserInfo selectById(@Param("id") Integer id);

    // 查询全部
    List<UserInfo> selectList();
}
