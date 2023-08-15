package com.example.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FindDocument {
    public static void insertDummyDocuments(MongoCollection<Document> collection) {

        List<Document> list = new ArrayList<Document>();

        Calendar cal = Calendar.getInstance();

        for (int i = 1; i <= 5; i++) {

            Document data = new Document();
            data.append("number", i);
            data.append("name", "mkyong-" + i);
            // data.append("date", cal.getTime());

            // +1 day
            cal.add(Calendar.DATE, 1);

            list.add(data);

        }

        collection.insertMany(list);

    }

    public static void main(String[] args) {

        try {

            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase database = mongoClient.getDatabase("test");

            // get a single collection
            MongoCollection<Document> collection = database.getCollection("dummyColl");

            insertDummyDocuments(collection);

            System.out.println("1. Find first matched document");
            Document document = collection.find().first();
            System.out.println(document);

            System.out.println("\n1. Find all matched documents");
            FindIterable<Document> documents = collection.find();
            MongoCursor<Document> mongoCursor = documents.iterator();
            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }

            System.out.println("\n1. Get 'name' field only");
//            Document allQuery = new Document();
            Document fields = new Document();
            fields.put("name", 1);

            FindIterable<Document> projection = collection.find().projection(fields);
            MongoCursor<Document> iterator = projection.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            System.out.println("\n2. Find where number = 5");
            Document whereQuery = new Document();
            whereQuery.put("number", 5);
            FindIterable<Document> whereDocuments = collection.find(whereQuery);
            MongoCursor<Document> whereIterator = whereDocuments.iterator();
            while (whereIterator.hasNext()) {
                System.out.println(whereIterator.next());
            }

            System.out.println("\n2. Find where number in 2,4 and 5");
            Document inQuery = new Document();
            List<Integer> list = new ArrayList<Integer>();
            list.add(2);
            list.add(4);
            list.add(5);
            inQuery.put("number", new Document("$in", list));
            FindIterable<Document> listDocuments = collection.find(inQuery);
            MongoCursor<Document> listIterator = listDocuments.iterator();
            while (listIterator.hasNext()) {
                System.out.println(listIterator.next());
            }

            System.out.println("\n2. Find where 5 > number > 2");
            Document gtQuery = new Document();
            gtQuery.put("number", new Document("$gt", 2).append("$lt", 5));
            FindIterable<Document> gtDocuments = collection.find(gtQuery);
            MongoCursor<Document> gtIterator = gtDocuments.iterator();
            while (gtIterator.hasNext()) {
                System.out.println(gtIterator.next());
            }

            System.out.println("\n2. Find where number != 4");
            Document neQuery = new Document();
            neQuery.put("number", new Document("$ne", 4));
            FindIterable<Document> neDocuments = collection.find(neQuery);
            MongoCursor<Document> neIterator = neDocuments.iterator();
            while (neIterator.hasNext()) {
                System.out.println(neIterator.next());
            }

            System.out.println("\n3. Find when number = 2 and name = 'mkyong-2' example");
            Document andQuery = new Document();

            List<Document> obj = new ArrayList<Document>();
            obj.add(new Document("number", 2));
            obj.add(new Document("name", "mkyong-2"));
            andQuery.put("$and", obj);

            System.out.println(andQuery.toString());

            FindIterable<Document> andDocuments = collection.find(andQuery);
            MongoCursor<Document> andIterator = andDocuments.iterator();
            while (andIterator.hasNext()) {
                System.out.println(andIterator.next());
            }

            System.out.println("\n4. Find where name = 'Mky.*-[1-3]', case sensitive example");
            Document regexQuery = new Document();
            regexQuery.put("name",
                    new Document("$regex", "Mky.*-[1-3]")
                            .append("$options", "i"));

            System.out.println(regexQuery.toString());

            FindIterable<Document> regexDocuments = collection.find(regexQuery);
            MongoCursor<Document> regexIterator = regexDocuments.iterator();
            while (regexIterator.hasNext()) {
                System.out.println(regexIterator.next());
            }

            collection.drop();

            System.out.println("Done");

        } catch (MongoException e) {
            e.printStackTrace();
        }

    }
}
