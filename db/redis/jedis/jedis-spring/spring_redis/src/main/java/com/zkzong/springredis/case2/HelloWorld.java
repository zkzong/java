package com.zkzong.springredis.case2;

import com.zkzong.springredis.case2.domain.User;
import com.zkzong.springredis.case2.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Zong on 2017/3/4.
 */
public class HelloWorld {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("case2/spring-config.xml");
        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");
        User user1 = new User("1", "user 1");
        User user2 = new User("2", "user 2");
        userRepository.put(user1);
        System.out.println("Step 1 output : " + userRepository.getObjects());
        userRepository.put(user2);
        System.out.println("Step 2 output : " + userRepository.getObjects());
//        userRepository.delete(user1);
//        System.out.println("Step 3 output : " + userRepository.getObjects());
    }
}
