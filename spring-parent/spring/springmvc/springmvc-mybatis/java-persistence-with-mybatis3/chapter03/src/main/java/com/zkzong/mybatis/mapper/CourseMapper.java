package com.zkzong.mybatis.mapper;

import com.zkzong.mybatis.domain.Course;

import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2017/3/11.
 */
public interface CourseMapper {
    List<Course> selectCoursesByTutor(int tutorId);

    List<Course> searchCourses(Map<String, Object> map);

    List<Course> searchCoursesByTutors(Map<String, Object> map);
}
