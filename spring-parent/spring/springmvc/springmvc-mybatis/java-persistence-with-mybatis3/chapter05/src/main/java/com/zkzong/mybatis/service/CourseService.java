package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Course;
import com.zkzong.mybatis.mapper.CourseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2017/3/11.
 */
@Service
@Transactional
public class CourseService {
//    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> selectCoursesByTutor(int tutorId) {
        return courseMapper.selectCoursesByTutor(tutorId);
    }

    public List<Course> searchCourses(Map<String, Object> map) {
        return courseMapper.searchCourses(map);
    }

    public List<Course> searchCoursesByTutors(Map<String, Object> map) {
        return courseMapper.searchCoursesByTutors(map);
    }
}
