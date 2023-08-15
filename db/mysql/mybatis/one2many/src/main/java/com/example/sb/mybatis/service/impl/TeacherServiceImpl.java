package com.example.sb.mybatis.service.impl;

import com.example.sb.mybatis.domain.Teacher;
import com.example.sb.mybatis.mapper.TeacherMapper;
import com.example.sb.mybatis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.9.5
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getTeachers() {
        return teacherMapper.getTeachers();
    }
}
