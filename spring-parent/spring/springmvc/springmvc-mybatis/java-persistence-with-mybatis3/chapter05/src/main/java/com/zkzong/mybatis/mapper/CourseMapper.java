package com.zkzong.mybatis.mapper;

import com.zkzong.mybatis.domain.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2017/3/11.
 */
public interface CourseMapper {
    @Select("select course_id as courseId, name, description, start_date as startDate from courses where tutor_id = #{tutorId}")
    List<Course> selectCoursesByTutor(int tutorId);

    @Select("select course_id as courseId, name, description, start_date as startDate from courses where tutor_id = #{tutorId}")
    List<Course> searchCourses(Map<String, Object> map);

    @Select("select course_id as courseId, name, description, start_date as startDate from courses where tutor_id in (#{tutorIds})")
    List<Course> searchCoursesByTutors(Map<String, Object> map);
}
