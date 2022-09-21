package org.example.sb.sentinel.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: Zong
 * @Date: 2018/10/22
 */
@Data
@ToString
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String age;
    private String grade;

}

