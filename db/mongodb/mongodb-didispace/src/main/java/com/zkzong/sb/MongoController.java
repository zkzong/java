package com.zkzong.sb;

import com.zkzong.sb.domain.FileRepository;
import com.zkzong.sb.domain.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MongoController {

    @Autowired
    private FileRepository fileRepository;

    @GetMapping("save")
    public String save() {
        FileVo fileVo = new FileVo();
        fileVo.setId(new Random().nextLong());
        fileVo.setContent("a".getBytes());
        fileRepository.save(fileVo);
        return "保存成功！";
    }
}
