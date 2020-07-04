package com.zkzong.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "t_user")
public class User {
    @Id
    private String id;
    @Field(value = "user_name")
    private String username;
    @Field(value = "create_time")
    private Date createTime;

}
