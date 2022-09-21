package org.example.sb.mybatis.mapper;

import org.example.sb.mybatis.domain.Student;

import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.9.5
 */
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> getStudents();
}
