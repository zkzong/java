package com.zkzong.aop.datalog;

import com.zkzong.aop.domain.Action;
import com.zkzong.aop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionDao extends MongoRepository<Action, String> {
}
