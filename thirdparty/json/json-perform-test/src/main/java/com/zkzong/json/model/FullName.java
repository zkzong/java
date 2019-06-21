package com.zkzong.json.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: zong
 * @Date: 2019-06-21
 */
@Getter
@Setter
public class FullName {
    private String firstName;
    private String middleName;
    private String lastName;

    public FullName() {
    }

    public FullName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "[firstName=" + firstName + ", middleName="
                + middleName + ", lastName=" + lastName + "]";
    }
}
