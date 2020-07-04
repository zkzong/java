package com.zkzong.seckill.dao;

import com.zkzong.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zong on 17-5-7.
 */
public interface SuccessKilledDao {
    //插入购买明细，可过滤重复
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    //根据id查询successKilled并携带秒杀对象实体
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
