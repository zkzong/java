package org.example.sb.mybatis.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.9.5
 */
@Data
public class Teacher {
    private Integer id;
    private String name;
    private String className;
    private List<Student> students;
}
