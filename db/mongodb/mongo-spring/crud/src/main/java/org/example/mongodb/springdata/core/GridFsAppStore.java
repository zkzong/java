package org.example.mongodb.springdata.core;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.example.mongodb.springdata.config.GridFsMongoConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class GridFsAppStore {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(GridFsMongoConfig.class);
        GridFsOperations gridOperations = (GridFsOperations) ctx.getBean("gridFsTemplate");

        DBObject metaData = new BasicDBObject();
        metaData.put("extra1", "anything 1");
        metaData.put("extra2", "anything 2");

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("mongodb.png");
            gridOperations.store(inputStream, "testing.png", "image/png", metaData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");

    }

}
