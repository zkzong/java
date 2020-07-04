package com.zkzong.mongo.repository;

import com.zkzong.mongo.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
