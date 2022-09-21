package org.example.sb.mybatis.mapper;

import org.example.sb.mybatis.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.9.5
 */
@Mapper
public interface TeacherMapper {
    List<Teacher> getTeachers();
}
