package com.example.sb.mybatis.controller;

import com.example.sb.mybatis.domain.City;
import com.example.sb.mybatis.mapper.CityDao;
import com.example.sb.mybatis.service.CityService;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private PlatformTransactionManager transactionManager;


    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }

    /**
     * 流式查询
     *
     * @param limit
     * @return
     */
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

        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);  // 1

        transactionTemplate.execute(status -> {               // 2
            try (Cursor<City> cursor = cityService.scan(limit)) {
                cursor.forEach(city -> {
                    System.out.println(city);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });

        return "success";
    }

    @GetMapping("/scan/{limit}")
    @Transactional
    public void scanFoo3(@PathVariable("limit") int limit) throws Exception {
        try (Cursor<City> cursor = cityService.scan(limit)) {
            cursor.forEach(city -> {
                System.out.println(city);
            });
        }
    }
}
