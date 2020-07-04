package com.zkzong.mongodb.dao;

import com.zkzong.mongodb.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
