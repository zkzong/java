package org.example.hutool.file;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileAppender;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class FileTest {

    /**
     * 获取文件类型
     */
    @Test
    public void fileType() {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        File file = new File(path + "/aaa.pdf");
        String type = FileTypeUtil.getType(file);
        System.out.println(type);

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("aaa.pdf");
        String type1 = FileTypeUtil.getType(inputStream);
        System.out.println(type1);
    }

    @Test
    public void fileutil() {
        // InputStream转File
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("aaa.pdf");
        File file = FileUtil.writeFromStream(inputStream, "a-a.pdf");
        System.out.println(file.getAbsolutePath());

        // 文件追加内容
        FileUtil.appendString("aa", "a.txt", StandardCharsets.UTF_8);

        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("bb");
        list.add("bbb");
        FileUtil.appendLines(list, "a.txt", StandardCharsets.UTF_8);
    }

    @Test
    public void fileAppender() {
        FileAppender fileAppender = new FileAppender(new File("a.txt"), StandardCharsets.UTF_8, 16, true, new ReentrantLock());
        fileAppender.append("aaa");
        fileAppender.append("bbb");
        fileAppender.append("ccc");
        fileAppender.flush();
        //fileAppender.toString();
    }

}
