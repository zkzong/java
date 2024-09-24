package com.example.sb.mybatis.mapper;

import com.example.sb.mybatis.domain.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zongz
 * @Date: 2024/9/24
 */
@Mapper
public interface IdMapper {

    int useGeneratedKeys(Users users);

    int selectkey(Users users);


}
