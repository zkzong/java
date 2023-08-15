package com.example.repository;

import com.example.entity.CustomerRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CustomerRelationRepository extends Neo4jRepository<CustomerRelation, Long> {
}
