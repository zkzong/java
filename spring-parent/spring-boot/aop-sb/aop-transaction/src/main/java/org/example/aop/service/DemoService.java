package org.example.aop.service;

import org.example.aop.dao.OperationLogDao;
import org.example.aop.dao.UserDao;
import org.example.aop.domain.OperationLog;
import org.example.aop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

    @Autowired
    UserDao userDao;

    @Autowired
    OperationLogDao operationLogDao;

    @Transactional
    public void addUser(String name) {
        OperationLog log = new OperationLog();
        log.setContent("create user:" + name);
        operationLogDao.save(log);

        User user = new User();
        user.setName(name);
        userDao.save(user);
    }
}
