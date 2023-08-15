package com.example.mp.mapper.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mp.entity.Temp;

/**
 * @Author: zkzong
 * @Date: 2018.9.8
 */
public interface TempMapper extends BaseMapper<Temp> {

    Temp getById(Integer id);
}
