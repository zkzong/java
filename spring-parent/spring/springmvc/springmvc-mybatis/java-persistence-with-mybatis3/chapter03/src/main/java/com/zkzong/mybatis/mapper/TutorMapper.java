package com.zkzong.mybatis.mapper;

import com.zkzong.mybatis.domain.Tutor;

/**
 * Created by Zong on 2017/3/11.
 */
public interface TutorMapper {
    Tutor selectTutorWithCourses(int tutorId);

    Tutor selectTutorById(int tutorId);
}
