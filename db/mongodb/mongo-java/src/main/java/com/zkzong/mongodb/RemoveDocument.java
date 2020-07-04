package com.zkzong.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class RemoveDocument {
    public static void main(String[] args) {

        try {

            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase database = mongoClient.getDatabase("test");

            // get a single collection
            MongoCollection<Document> collection = database.getCollection("dummyColl");

            //insert number 1 to 10 for testing
            for (int i = 1; i <= 10; i++) {
                collection.insertOne(new Document().append("number", i));
            }

            //remove number = 1
            Document doc = collection.find().first(); //get first document
            collection.deleteOne(doc);

            //remove number = 2
            Document document = new Document();
            document.put("number", 2);
            collection.deleteOne(document);

            //remove number = 3
            collection.deleteOne(new Document().append("number", 3));

            //remove number > 9 , means delete number = 10
            Document query = new Document();
            query.put("number", new Document("$gt", 9));
            collection.deleteOne(query);

            //remove number = 4 and 5
            Document query2 = new Document();
            List<Integer> list = new ArrayList<Integer>();
            list.add(4);
            list.add(5);
            query2.put("number", new Document("$in", list));
            collection.deleteOne(query2);

            FindIterable<Document> deleteDocuments = collection.find();
            MongoCursor<Document> deleteIterator = deleteDocuments.iterator();
            while (deleteIterator.hasNext()) {
                collection.deleteOne(deleteIterator.next());
            }

            collection.deleteMany(new Document());

            collection.drop();

            DeleteResult deleteResult = collection.deleteMany(new Document());
            System.out.println("删除文档数：" + deleteResult.getDeletedCount());

            //print out the document
            FindIterable<Document> documents = collection.find();
            MongoCursor<Document> iterator = documents.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            collection.drop();

            System.out.println("Done");

        } catch (MongoException e) {
            e.printStackTrace();
        }

    }
}
