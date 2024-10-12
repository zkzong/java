package com.example.sb.mybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateServiceTest {

    @Autowired
    private UpdateService updateService;

    @Test
    public void update() {
        Integer update = updateService.update();
        System.out.println(update);
    }

    @Test
    public void updateRows() {
        Integer updateRows = updateService.updateRows();
        System.out.println(updateRows);
    }

}