package com.zkzong.sb;

import com.zkzong.sb.domain.FileRepository;
import com.zkzong.sb.domain.FileVo;
import com.zkzong.sb.domain.User;
import com.zkzong.sb.domain.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @author zkzong
 * @date 2017/10/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MongoApplication.class)
public class MongoApplicationTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileRepository fileRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
        fileRepository.deleteAll();
    }

    @Test
    public void test() {
        // 创建三个User，并验证User总数
        userRepository.save(new User(1L, "didi", 30));
        userRepository.save(new User(2L, "mama", 40));
        userRepository.save(new User(3L, "kaka", 50));
        Assert.assertEquals(3, userRepository.findAll().size());
        // 删除一个User，再验证User总数
        User u = userRepository.findOne(1L);
        userRepository.delete(u);
        Assert.assertEquals(2, userRepository.findAll().size());
        // 删除一个User，再验证User总数
        u = userRepository.findByUsername("mama");
        userRepository.delete(u);
        Assert.assertEquals(1, userRepository.findAll().size());
    }

    @Test
    public void date() {
        userRepository.save(new User(1L, "didi", 30, new Date()));
        User user = userRepository.findByUsername("didi");
        System.out.println(user);
    }

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