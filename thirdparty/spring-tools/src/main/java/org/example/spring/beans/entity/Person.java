package org.example.spring.beans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Zong on 2016/8/6.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;
    private int age;

}
