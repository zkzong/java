package com.example.sb.mybatis.service;

import com.alibaba.fastjson.JSON;
import com.example.sb.mybatis.domain.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.9.5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void getTeachers() {
        List<Teacher> teachers = teacherService.getTeachers();
        System.out.println(JSON.toJSONString(teachers));
    }
}