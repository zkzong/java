package com.zkzong.mongodb.runoob;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
        try {
            // 连接到mongodb服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("coll");
            System.out.println("集合coll选择成功");

            // 插入文档
            /**
             * 1. 创建文档org.bson.Document参数为key-value格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中mongoCollection.insertMany(List<Document>) 插入单个文档可以用mongoCollection.insertOne(Document)
             */
            Document document = new Document("title", "MongoDB")
                    .append("description", "database")
                    .append("likes", 100)
                    .append("by", "zong");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("文档插入成功");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
        }
    }
}
