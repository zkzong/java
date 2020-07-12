package com.zkzong.job.repository;

import com.zkzong.job.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FooRepository extends JpaRepository<Foo, Integer> {
    List<Foo> findByStatus(String status);
}
