
package com.zkzong.sj5.service;

import com.zkzong.sj5.entity.Order;
import com.zkzong.sj5.entity.ShadowUser;
import com.zkzong.sj5.mapper.ShadowUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("shadow")
public class ShadowUserServiceImpl implements ExampleService {

    @Resource
    private ShadowUserMapper shadowUserMapper;

    @Override
    public void initEnvironment() throws SQLException {
        shadowUserMapper.createTableIfNotExists();
        shadowUserMapper.truncateTable();
    }

    @Override
    public void cleanEnvironment() throws SQLException {
        shadowUserMapper.dropTable();
    }

    @Override
    public void processSuccess() throws SQLException {
        System.out.println("-------------- Process Success Begin ---------------");
        List<Long> userIds = insertData();
        printData();
        deleteData(userIds);
        printData();
        System.out.println("-------------- Process Success Finish --------------");
    }

    private List<Long> insertData() throws SQLException {
        System.out.println("---------------------------- Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            ShadowUser user = new ShadowUser();
            user.setUserId(i);
            user.setUserName("test_mybatis_" + i);
            user.setPwd("pwd_mybatis_" + i);
            user.setShadow(i % 2 == 0);
            shadowUserMapper.insert(user);
            result.add((long) user.getUserId());
        }
        return result;
    }

    @Override
    public void processFailure() throws SQLException {
        System.out.println("-------------- Process Failure Begin ---------------");
        insertData();
        System.out.println("-------------- Process Failure Finish --------------");
        throw new RuntimeException("Exception occur for transaction test.");
    }

    private void deleteData(final List<Long> userIds) throws SQLException {
        System.out.println("---------------------------- Delete Data ----------------------------");
        for (Long each : userIds) {
            shadowUserMapper.delete(each, true);
        }
    }

    @Override
    public void printData() throws SQLException {
        System.out.println("---------------------------- Print User Data -----------------------");
        for (Object each : shadowUserMapper.selectAll()) {
            System.out.println(each);
        }
    }

    @Override
    public List<Order> selectRange() {
        return null;
    }
}
