package org.example.aop.dao;

import org.example.aop.domain.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationLogDao extends JpaRepository<OperationLog, Long> {
}
