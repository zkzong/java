//
//package com.example.sj4.service;
//
//import com.example.sj4.entity.User;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service("encrypt")
//public class UserServiceImpl implements ExampleService {
//
//    @Resource
//    private UserRepository userRepository;
//
//    @Override
//    public void initEnvironment() throws SQLException {
//        userRepository.createTableIfNotExists();
//        userRepository.truncateTable();
//    }
//
//    @Override
//    public void cleanEnvironment() throws SQLException {
//        userRepository.dropTable();
//    }
//
//    @Override
//    public void processSuccess() throws SQLException {
//        System.out.println("-------------- Process Success Begin ---------------");
//        List<Long> userIds = insertData();
//        printData();
//        deleteData(userIds);
//        printData();
//        System.out.println("-------------- Process Success Finish --------------");
//    }
//
//    private List<Long> insertData() throws SQLException {
//        System.out.println("---------------------------- Insert Data ----------------------------");
//        List<Long> result = new ArrayList<>(10);
//        for (int i = 1; i <= 10; i++) {
//            User user = new User();
//            user.setUserId(i);
//            user.setUserName("test_mybatis_" + i);
//            user.setPwd("pwd_mybatis_" + i);
//            userRepository.insert(user);
//            result.add((long) user.getUserId());
//        }
//        return result;
//    }
//
//    @Override
//    public void processFailure() throws SQLException {
//        System.out.println("-------------- Process Failure Begin ---------------");
//        insertData();
//        System.out.println("-------------- Process Failure Finish --------------");
//        throw new RuntimeException("Exception occur for transaction test.");
//    }
//
//    private void deleteData(final List<Long> userIds) throws SQLException {
//        System.out.println("---------------------------- Delete Data ----------------------------");
//        for (Long each : userIds) {
//            userRepository.delete(each);
//        }
//    }
//
//    @Override
//    public void printData() throws SQLException {
//        System.out.println("---------------------------- Print User Data -----------------------");
//        for (Object each : userRepository.selectAll()) {
//            System.out.println(each);
//        }
//    }
//}
