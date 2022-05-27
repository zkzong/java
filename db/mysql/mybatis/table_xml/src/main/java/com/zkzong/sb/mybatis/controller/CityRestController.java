package com.zkzong.sb.mybatis.controller;

import com.zkzong.sb.mybatis.domain.City;
import com.zkzong.sb.mybatis.mapper.CityDao;
import com.zkzong.sb.mybatis.service.CityService;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Zong on 2017/6/5.
 */
@RestController
public class CityRestController {
    @Autowired
    private CityService cityService;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private transactionmanager transactionManager;


    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value = "/scan", method = RequestMethod.GET)
    public String findOneCity(int limit) {
        // java.lang.IllegalStateException: A Cursor is already closed.
        //Cursor<City> cursor = cityService.scan(limit);
        //cursor.forEach(city -> {
        //    System.out.println(city);
        //});

        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();  // 1
                Cursor<City> cursor = sqlSession.getMapper(CityDao.class).scan(limit)   // 2
        ) {
            cursor.forEach(city -> {
                System.out.println(city);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TransactionTemplate transactionTemplate =
                new TransactionTemplate(transactionManager);  // 1

        transactionTemplate.execute(status -> {               // 2
            try (Cursor<City> cursor = cityService.scan(limit)) {
                cursor.forEach(city -> {
                    System.out.println(city);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "success";
        }
    }
