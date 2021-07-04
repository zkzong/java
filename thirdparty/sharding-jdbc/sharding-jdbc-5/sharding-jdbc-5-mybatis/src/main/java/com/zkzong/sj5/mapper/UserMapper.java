
package com.zkzong.sj5.mapper;

import com.zkzong.sj5.entity.User;

import java.util.List;

public interface UserMapper {
    void createTableIfNotExists();

    void truncateTable();

    void dropTable();

    int insert(User user);

    void delete(Long userId);

    List<User> selectAll();
}
