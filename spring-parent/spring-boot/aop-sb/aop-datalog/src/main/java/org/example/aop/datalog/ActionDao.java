package org.example.aop.datalog;

import org.example.aop.domain.Action;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionDao extends MongoRepository<Action, String> {
}
