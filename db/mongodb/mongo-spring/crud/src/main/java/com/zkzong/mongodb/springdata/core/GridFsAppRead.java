package com.zkzong.mongodb.springdata.core;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import java.io.IOException;
import java.util.List;

public class GridFsAppRead {

    public static void main(String[] args) {

        ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
        GridFsOperations gridOperations = (GridFsOperations) ctx.getBean("gridFsTemplate");

        List<GridFSDBFile> result = gridOperations.find(
                new Query().addCriteria(Criteria.where("filename").is("testing.png"))
        );
        for (GridFSDBFile file : result) {
            try {
                System.out.println(file.getFilename());
                System.out.println(file.getContentType());

                //save as another image
                file.writeTo("new-testing.png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Done");

    }

}
