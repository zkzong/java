package org.example.sb.mybatis.service;

import org.example.sb.mybatis.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    public void findCityByName() {
        City city = cityService.findCityByName("m");
        System.out.println(city);
    }
}