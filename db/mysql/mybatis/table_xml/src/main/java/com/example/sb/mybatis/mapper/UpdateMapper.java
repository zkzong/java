package com.example.sb.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Zong on 2017/6/1.
 */
@Mapper
public interface UpdateMapper {

    Integer update();

    Integer updateRows();

}
