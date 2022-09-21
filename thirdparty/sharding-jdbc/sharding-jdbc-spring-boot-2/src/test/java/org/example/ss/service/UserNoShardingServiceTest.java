package org.example.ss.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserNoShardingServiceTest {

    @Autowired
    @Qualifier(value = "userNoShardingService")
    private ExampleService userNoShardingService;

    @Test
    public void insert() throws SQLException {
        userNoShardingService.processSuccess();
    }

}