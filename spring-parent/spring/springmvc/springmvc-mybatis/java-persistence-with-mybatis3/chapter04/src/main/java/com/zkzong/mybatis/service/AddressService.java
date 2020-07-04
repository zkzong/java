package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Address;
import com.zkzong.mybatis.mapper.AddressMapper;
import com.zkzong.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Zong on 2017/3/11.
 */
public class AddressService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public Address findAddressById(int addrId) {
        logger.debug("findAddressById : " + addrId);
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
            return mapper.selectAddressById(addrId);
        } finally {
            sqlSession.close();
        }
    }

}
