package com.zkzong.json.entity;

/**
 * Created by Zong on 2017/2/25.
 */
public class Birthday {
    private String birthday;

    public Birthday() {
    }

    public Birthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "birthday='" + birthday + '\'' +
                '}';
    }
}
