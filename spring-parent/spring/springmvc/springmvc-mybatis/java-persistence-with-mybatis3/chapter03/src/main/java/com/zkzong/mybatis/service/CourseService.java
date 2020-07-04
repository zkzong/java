package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Course;
import com.zkzong.mybatis.mapper.CourseMapper;
import com.zkzong.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2017/3/11.
 */
public class CourseService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<Course> searchCourses(Map<String, Object> map) {
        logger.debug("searchCourses By : " + map);
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            return mapper.searchCourses(map);
        } finally {
            sqlSession.close();
        }
    }

    public List<Course> searchCoursesByTutors(Map<String, Object> map) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            return mapper.searchCoursesByTutors(map);
        } finally {
            sqlSession.close();
        }
    }
}
