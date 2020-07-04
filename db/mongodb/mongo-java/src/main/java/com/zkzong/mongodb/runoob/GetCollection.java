package com.zkzong.mongodb.runoob;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class GetCollection {
    public static void main(String[] args) {
        try {
            // 连接到mongodb服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("coll");
            System.out.println("集合coll选择成功");

            // 所有集合
            MongoIterable<String> collections = mongoDatabase.listCollectionNames();
            for (String c : collections) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
        }
    }
}
