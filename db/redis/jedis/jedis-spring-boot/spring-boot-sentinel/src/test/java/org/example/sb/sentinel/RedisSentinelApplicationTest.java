package org.example.sb.sentinel;

import org.example.sb.sentinel.service.RedisService;
import org.example.sb.sentinel.vo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Zong
 * @Date: 2018/10/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSentinelApplicationTest {

    @Autowired
    private RedisService service;

    @Test
    public void contextLoads() {
        service.set("name", "zong");
        Student s = new Student();
        s.setId("001");
        s.setName("zong");
        s.setGrade("一年级");
        s.setAge("28");
        service.set(s);

        String name = service.get("name");
        System.out.println("name:" + name);

        Student stu = service.getStudent("001");
        System.out.println(stu);
    }

}