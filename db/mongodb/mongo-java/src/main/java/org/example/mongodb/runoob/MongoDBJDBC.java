package org.example.mongodb.runoob;

import com.mongodb.MongoClient;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class MongoDBJDBC {
    public static void main(String[] args) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");

            MongoDatabase database = mongoClient.getDatabase("t");

            // 列举所有数据库
            MongoIterable<String> dbs = mongoClient.listDatabaseNames();
            for (String db : dbs) {
                System.out.println(db);
            }
            ListDatabasesIterable<Document> documents = mongoClient.listDatabases();
            for (Document document : documents) {
                System.out.println(document);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
        }

    }
}
