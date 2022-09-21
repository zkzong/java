package org.example.mongodb.runoob;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Update {
    public static void main(String[] args) {
        try {
            // 连接到mongodb服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("coll");
            System.out.println("集合coll选择成功");

            // 更新文档 将文档中likes=100的文档修改为likes=200
//            collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
            collection.updateMany(Filters.eq("likes", 200), new Document("$inc", new Document("likes", 300)));

            // 检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
        }
    }
}
