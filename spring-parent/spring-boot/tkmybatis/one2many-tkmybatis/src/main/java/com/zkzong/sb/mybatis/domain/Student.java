package com.zkzong.sb.mybatis.domain;

import lombok.Data;

/**
 * @Author: zkzong
 * @Date: 2018.9.5
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private Integer teacherId;
    private String className;
    private Teacher teacher;
}
