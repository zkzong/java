package com.example.sb.redis.service;

import com.example.sb.redis.domain.City;
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
    public void findCityById() {
    }

    @Test
    public void saveCity() {
        City city = new City();
        city.setProvinceId(1L);
        city.setCityName("henan");
        city.setDescription("河南");
        Long i = cityService.saveCity(city);
        System.out.println(i);
        System.out.println(city.getId());
    }

    @Test
    public void updateCity() {
    }

    @Test
    public void deleteCity() {
    }
}