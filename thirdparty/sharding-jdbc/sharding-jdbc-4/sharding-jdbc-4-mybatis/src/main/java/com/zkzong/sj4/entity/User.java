
package com.zkzong.sj4.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer userId;

    private String userName;

    private String userNamePlain;

    private String pwd;

    private String assistedQueryPwd;

}
