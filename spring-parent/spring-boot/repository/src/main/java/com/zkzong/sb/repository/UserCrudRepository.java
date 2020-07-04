package com.zkzong.sb.repository;

import com.zkzong.sb.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> {

    User findByName(String name);

}
