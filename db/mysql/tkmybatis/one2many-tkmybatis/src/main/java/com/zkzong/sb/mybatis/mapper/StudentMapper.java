package com.zkzong.sb.mybatis.mapper;

import com.zkzong.sb.mybatis.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.9.5
 */
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> getStudents();
}
