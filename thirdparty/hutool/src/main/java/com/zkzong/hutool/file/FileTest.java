package com.zkzong.hutool.file;

import cn.hutool.core.io.FileTypeUtil;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

public class FileTest {

    @Test
    public void fileType() {
        File file = new File("D:/aaa.pdf");
        String type = FileTypeUtil.getType(file);
        System.out.println(type);

        InputStream inputStream = FileTest.class.getClassLoader().getResourceAsStream("aaa.pdf");
        String type1 = FileTypeUtil.getType(inputStream);
        System.out.println(type1);
    }
}
