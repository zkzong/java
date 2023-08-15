package com.example.sb.repository;

import com.example.sb.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> {

    User findByName(String name);

}
