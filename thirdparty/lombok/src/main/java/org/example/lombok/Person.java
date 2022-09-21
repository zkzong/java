package org.example.lombok;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zong on 2017/3/27.
 */
@Data
//@Getter
//@Setter
//@Accessors(chain = true)
public class Person implements Serializable {

    //    @Getter(AccessLevel.PUBLIC)
//    @Setter(AccessLevel.PUBLIC)
    private String name;
    private Integer age;
    private char sex;
    private Double height;
    private String address;

//    public static void main(String[] args) {
//        Person p = new Person();
//
//    }
}
