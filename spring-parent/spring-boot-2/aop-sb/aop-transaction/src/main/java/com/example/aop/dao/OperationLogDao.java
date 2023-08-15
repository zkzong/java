package com.example.aop.dao;

import com.example.aop.domain.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationLogDao extends JpaRepository<OperationLog, Long> {
}
