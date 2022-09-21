package org.example.mongodb.runoob;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class CreateCollection {
    public static void main(String[] args) {
        try {
            // 连接到mongodb服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");
            mongoDatabase.createCollection("coll");
            System.out.println("集合创建成功");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
        }
    }
}
