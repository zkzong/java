package com.example.property;

import org.junit.Test;

import java.util.ResourceBundle;

/**
 * Created by zong on 2017/3/4.
 */
public class ResourceBundleTest {
    ResourceBundle bundle = ResourceBundle.getBundle("application");

    @Test
    public void getString() {
        String uploadPath = bundle.getString("uploadPath");
        System.out.println("uploadPath = " + uploadPath);
    }
}
