package com.zkzong.sb;

import com.zkzong.sb.domain.FileRepository;
import com.zkzong.sb.domain.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zkzong
 * @date 2017/11/23
 */
@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public void run(String... args) throws Exception {
        FileVo fileVo = new FileVo();
        fileVo.setId(11L);
        fileRepository.save(fileVo);
    }
}
