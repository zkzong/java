package com.example.aop.datalog;

import com.example.aop.domain.Action;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionDao extends MongoRepository<Action, String> {
}
