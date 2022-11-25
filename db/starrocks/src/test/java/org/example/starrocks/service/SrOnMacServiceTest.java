package org.example.starrocks.service;

import org.example.starrocks.entity.SrOnMac;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SrOnMacServiceTest {

    @Resource
    private SrOnMacService srOnMacService;

    @Test
    public void query() {
        List<SrOnMac> list = srOnMacService.select(null);
        System.out.println(list);
    }

    @Test
    public void save() {
        srOnMacService.save();
    }

    @Test
    public void insertOne() {
        srOnMacService.insertOne(8L, "2022-2-6", "2022-2-6", "888");
    }
}