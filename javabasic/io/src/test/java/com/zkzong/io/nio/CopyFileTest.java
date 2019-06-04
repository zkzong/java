package com.zkzong.io.nio;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author: Zong
 * @Date: 2018/12/9
 */
public class CopyFileTest {

    @Test
    public void copyFile() throws IOException {
        String inFilePath = "file/github.txt";
        String outFilePath = "file/github2.txt";

        CopyFile cf = new CopyFile();
        cf.copyFile(inFilePath, outFilePath);
    }

}