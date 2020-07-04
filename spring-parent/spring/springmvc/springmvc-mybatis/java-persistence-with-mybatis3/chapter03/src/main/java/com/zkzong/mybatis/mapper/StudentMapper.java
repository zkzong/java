package com.zkzong.mybatis.mapper;

import com.zkzong.mybatis.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2017/3/10.
 */
public interface StudentMapper {
    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    Student selectStudentWithAddress(int id);

    void insertStudent(Student student);

    void insertStudentWithMap(Map<String, Object> map);

    void updateStudent(Student student);

    int deleteStudent(int id);
}
