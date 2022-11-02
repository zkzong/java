package org.example.clickhouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.example.clickhouse.pojo.UserInfo;

import java.util.List;

public interface UserInfoService extends IService<UserInfo> {

    // 写入数据
    void saveData(UserInfo userInfo);

    // ID 查询
    UserInfo selectById(@Param("id") Integer id);

    // 查询全部
    List<UserInfo> selectList();
}
