package com.example.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
public class CustomerNode {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
}
