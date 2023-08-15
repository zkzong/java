
package com.example.sj5.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShadowUser implements Serializable {

    private Integer userId;

    private String userName;

    private String userNamePlain;

    private String pwd;

    private String assistedQueryPwd;

    private Boolean shadow;

}
