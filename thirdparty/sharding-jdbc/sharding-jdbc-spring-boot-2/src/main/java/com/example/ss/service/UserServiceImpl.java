package com.example.ss.service;

import com.example.ss.entity.UserEntity;
import com.example.ss.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("encrypt")
public class UserServiceImpl implements ExampleService {

    @Resource
    private UserRepository userRepository;

    @Override
    public void initEnvironment() {
    }

    @Override
    public void cleanEnvironment() {
    }

    @Override
    @Transactional
    public void processSuccess() throws SQLException {
        System.out.println("-------------- Process Success Begin ---------------");
        List<Long> userIds = insertData();
        printData();
        deleteData(userIds);
        printData();
        System.out.println("-------------- Process Success Finish --------------");
    }

    @Override
    @Transactional
    public void processFailure() throws SQLException {
        System.out.println("-------------- Process Failure Begin ---------------");
        insertData();
        System.out.println("-------------- Process Failure Finish --------------");
        throw new RuntimeException("Exception occur for transaction test.");
    }

    private List<Long> insertData() throws SQLException {
        System.out.println("---------------------------- Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            UserEntity user = new UserEntity();
            user.setUserId(i);
            user.setUserName("test_jpa_" + i);
            user.setPwd("pwd_jpa_" + i);
            userRepository.insert(user);
            result.add((long) user.getUserId());
        }
        return result;
    }

    private void deleteData(final List<Long> userIds) {
//        System.out.println("---------------------------- Delete Data ----------------------------");
//        for (Long each : userIds) {
//            userRepository.delete(each);
//        }
    }

    @Override
    public void printData() {
        System.out.println("---------------------------- Print User Data -----------------------");
//        for (Object each : userRepository.selectAll()) {
//            System.out.println(each);
//        }
    }
}
