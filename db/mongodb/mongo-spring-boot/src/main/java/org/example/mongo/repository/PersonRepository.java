package org.example.mongo.repository;

import org.example.mongo.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
