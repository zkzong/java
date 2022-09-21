package org.example.filetype.e2;

import org.junit.Test;

/**
 * @Author: Zong
 * @Date: 2018/12/9
 */
public class FileTypeTest {

    @Test
    public void getFileType() {
        String type = FileType.getFileType("file/bd.pdf");
        System.out.println("bd.pdf : " + type);

        type = FileType.getFileType("file/bd.png");
        System.out.println("bd.png : " + type);
    }
}
