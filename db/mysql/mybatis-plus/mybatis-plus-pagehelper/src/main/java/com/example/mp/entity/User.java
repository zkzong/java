package com.example.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@TableName("t_user")
public class User {

    @TableId(value = "f_id", type = IdType.AUTO)
    private Long id;
    @TableField("f_user_name")
    private String userName;
    @TableField("f_sex")
    private String sex;
    @TableField("f_age")
    private Integer age;
    @TableField("f_address")
    private String address;
    @TableField("f_create_time")
    private Date createTime;
    @TableField("f_update_time")
    private Date updateTime;

}
