package org.example.exception;

import org.junit.Test;

import java.io.IOException;

/**
 * @Author: Zong
 * @Date: 2018/12/9
 */
public class TryWithResourcesTest {

    @Test
    public void tryResource() throws IOException {
        String filePath = "file/test.txt";
        TryWithResources tr = new TryWithResources();
        tr.tryResource(filePath);
    }

}