package org.example.sb.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: zkzong
 * @Date: 2018.9.6
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
