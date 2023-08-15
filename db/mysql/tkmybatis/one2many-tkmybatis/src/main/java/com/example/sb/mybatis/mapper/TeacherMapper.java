package com.example.sb.mybatis.mapper;

import com.example.sb.mybatis.domain.Teacher;

import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.9.5
 */
public interface TeacherMapper extends BaseMapper<Teacher> {
    List<Teacher> getTeachers();
}
