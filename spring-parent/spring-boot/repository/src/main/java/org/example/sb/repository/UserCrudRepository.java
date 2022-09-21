package org.example.sb.repository;

import org.example.sb.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> {

    User findByName(String name);

}
