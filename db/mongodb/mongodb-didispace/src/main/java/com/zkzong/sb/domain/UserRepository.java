package com.zkzong.sb.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author zkzong
 * @date 2017/10/20
 */
public interface UserRepository extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
