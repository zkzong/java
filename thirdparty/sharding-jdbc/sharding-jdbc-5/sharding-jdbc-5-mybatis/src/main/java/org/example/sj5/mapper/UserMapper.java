
package org.example.sj5.mapper;

import org.example.sj5.entity.User;

import java.util.List;

public interface UserMapper {
    void createTableIfNotExists();

    void truncateTable();

    void dropTable();

    int insert(User user);

    void delete(Long userId);

    List<User> selectAll();
}
