package com.zkzong.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zong on 2017/3/14.
 */
@Configuration
@MapperScan(value = "com.zkzong.mybatis.mapper")
public class AppConfig {
//    @Bean
//    public DataSource dataSource() {
//        return new PooledDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mybatis", "root", "root");
//    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        return sessionFactory.getObject();
//    }
}
