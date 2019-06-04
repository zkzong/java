package com.zkzong.serializable;

import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = 5706780768957448675L;

    private String username;
    private transient String passwd;
    protected static transient Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
