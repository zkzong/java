package cn.springcloud.book.feign.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: zongz
 * @Date: 2024/9/1
 */
@Data
@ToString
public class UserRequest {

    private String username;
    private String password;

}
