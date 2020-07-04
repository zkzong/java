package com.zkzong.ss.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_user_no_sharding")
@Getter
@Setter
public class UserNoSharding implements Serializable {
    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_name_plain")
    private String userNamePlain;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "assisted_query_pwd")
    private String assistedQueryPwd;
}
