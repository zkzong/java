package com.zkzong.mongo.repository;

import com.zkzong.mongo.entity.FileVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileRepositoryTest {

    @Autowired
    private FileRepository fileRepository;

    @Test
    public void file() throws IOException {
        FileVo fileVo = new FileVo();
        fileVo.setId(2L);
        File file = new File("20171017016601000007_end.pdf");
        byte[] bFile = Files.readAllBytes(file.toPath());
        fileVo.setContent(bFile);
        fileRepository.save(fileVo);

        FileVo fileVo1 = fileRepository.findById(2L);
        byte[] content = fileVo1.getContent();
        Path path = Paths.get("a.pdf");
        Files.write(path, content);
    }

}