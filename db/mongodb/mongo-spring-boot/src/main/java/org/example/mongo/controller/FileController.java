package com.example.mongo.controller;

import com.example.mongo.entity.FileVo;
import com.example.mongo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FileController {

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
