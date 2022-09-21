package org.example.mp.mapper.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.mp.entity.Temp;

/**
 * @Author: zkzong
 * @Date: 2018.9.8
 */
public interface TempMapper extends BaseMapper<Temp> {

    Temp getById(Integer id);
}
