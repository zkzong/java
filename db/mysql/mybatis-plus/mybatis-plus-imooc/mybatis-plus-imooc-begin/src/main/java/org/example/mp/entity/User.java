package com.example.mp.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {
    // 主键
    //@TableId(type = IdType.ID_WORKER)
    private Long id;
    // 姓名
    //@TableField(condition = SqlCondition.LIKE)
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String name;
    // 年龄
    private Integer age;
    // 邮箱
    private String email;
    // 直属上级
    private Long managerId;
    // 创建时间
    private LocalDateTime createTime;
}
