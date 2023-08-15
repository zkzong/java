package com.example.mongodb.springdata.core;

import com.example.mongodb.springdata.config.SpringMongoConfig;
import com.example.mongodb.springdata.user.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");

        // Case1 - insert a user, put "tableA" as collection name
        System.out.println("Case 1...");
        User userA = new User("1000", "apple", 54, new Date());
        mongoOperations.save(userA, "tableA");

        Query findUserQuery = new Query();
        findUserQuery.addCriteria(Criteria.where("ic").is("1000"));
        User userA1 = mongoOperations.findOne(findUserQuery, User.class, "tableA");
        System.out.println(userA1);

        // Case2 - insert a user, put entity as collection name
        System.out.println("Case 2...");
        User userB = new User("2000", "orange", 64, new Date());
        mongoOperations.save(userB);

        User userB1 = mongoOperations.findOne(new Query(Criteria.where("age").is(64)), User.class);
        System.out.println(userB1);

        // Case3 - insert a list of users
        System.out.println("Case 3...");
        User userC = new User("3000", "metallica", 34, new Date());
        User userD = new User("4000", "metallica", 34, new Date());
        User userE = new User("5000", "metallica", 34, new Date());
        List<User> userList = new ArrayList<User>();
        userList.add(userC);
        userList.add(userD);
        userList.add(userE);
        mongoOperations.insert(userList, User.class);

        List<User> users = mongoOperations.find(new Query(Criteria.where("name").is("metallica")), User.class);
        for (User user : users) {
            System.out.println(user);
        }

        // save vs insert
        System.out.println("Case 4...");
        User userD1 = mongoOperations.findOne(new Query(Criteria.where("age").is(64)), User.class);
        userD1.setName("new name");
        userD1.setAge(100);

        // E11000 duplicate key error index, _id existed
//        mongoOperations.insert(userD1);
        mongoOperations.save(userD1);
        User userE1 = mongoOperations.findOne(new Query(Criteria.where("age").is(100)), User.class);
        System.out.println(userE1);
    }
}
