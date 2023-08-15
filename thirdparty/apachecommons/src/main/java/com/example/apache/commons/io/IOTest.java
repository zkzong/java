package com.example.apache.commons.io;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOTest {

    public static void main(String[] args) {
        URL resource = IOTest.class.getClassLoader().getResource("config.properties");
        String file = resource.getFile();
        System.out.println(file);

        try {
            URI uri = resource.toURI();
            File f = new File(uri);
            String absolutePath = f.getAbsolutePath();
            System.out.println(absolutePath);

            String replace = absolutePath.replace('\\', '/');
            System.out.println(replace);


            Path fileName = Paths.get(uri).getFileName();
            System.out.println(fileName);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
