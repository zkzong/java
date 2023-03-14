package org.example.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by zong on 2017/2/12.
 */
public class TryWithResources {
    public void tryResource(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        }
    }
}
