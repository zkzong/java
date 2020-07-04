package com.zkzong.mongo.repository;

import com.zkzong.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author: Zong
 * @Date: 2019/3/20
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String userName);

    List<User> findUsersByUsername(String userName);

}
