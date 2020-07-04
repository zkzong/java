package com.zkzong.mybatis.util;

import com.zkzong.mybatis.domain.Student;
import com.zkzong.mybatis.mapper.StudentMapper;
import com.zkzong.mybatis.typehandler.PhoneTypeHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zong on 2017/3/10.
 */
public class MyBatisUtil {
    private static SqlSessionFactory xmlSqlSessionFactory;
    private static SqlSessionFactory javaSqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactoryUsingXML() {
        if (xmlSqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                xmlSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return xmlSqlSessionFactory;
    }

    public static SqlSessionFactory getSqlSessionFactoryUsingJavaAPI() {
        if (javaSqlSessionFactory == null) {
            try {
                DataSource dataSource = DataSourceFactory.getDataSource();
                TransactionFactory transactionFactory = new JdbcTransactionFactory();
                Environment environment = new Environment("development", transactionFactory, dataSource);
                Configuration configuration = new Configuration(environment);
                configuration.getTypeAliasRegistry().registerAlias("student", Student.class);
                configuration.getTypeHandlerRegistry().register(PhoneTypeHandler.class);
                configuration.addMapper(StudentMapper.class);
                javaSqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return javaSqlSessionFactory;
    }
}
