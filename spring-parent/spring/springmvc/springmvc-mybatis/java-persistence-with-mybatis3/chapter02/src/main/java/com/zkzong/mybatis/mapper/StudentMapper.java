package com.zkzong.mybatis.mapper;

import com.zkzong.mybatis.domain.Student;

import java.util.List;

/**
 * Created by Zong on 2017/3/10.
 */
public interface StudentMapper {
    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    void insertStudent(Student student);

    void updateStudent(Student student);
}
