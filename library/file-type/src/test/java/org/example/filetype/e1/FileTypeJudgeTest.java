package com.example.filetype.e1;

import org.junit.Test;

import java.io.IOException;

/**
 * @Author: Zong
 * @Date: 2018/12/9
 */
public class FileTypeJudgeTest {

    @Test
    public void getType() {
        try {
            System.out.println(FileTypeJudge.getType("file/bd.pdf"));
            System.out.println(FileTypeJudge.getType("file/bd.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
