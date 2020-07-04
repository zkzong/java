package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Tutor;
import com.zkzong.mybatis.mapper.TutorMapper;
import com.zkzong.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Zong on 2017/3/11.
 */
public class TutorService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public Tutor findTutorById(int tutorId) {
        logger.debug("findTutorById : " + tutorId);
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);
            return mapper.selectTutorById(tutorId);
        } finally {
            sqlSession.close();
        }
    }

    public Tutor selectTutorWithCourses(int tutorId) {
        logger.debug("findTutorById : " + tutorId);
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);
            return mapper.selectTutorWithCourses(tutorId);
        } finally {
            sqlSession.close();
        }
    }

}
