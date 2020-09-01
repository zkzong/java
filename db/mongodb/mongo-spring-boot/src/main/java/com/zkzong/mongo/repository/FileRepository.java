package com.zkzong.mongo.repository;

import com.zkzong.mongo.entity.FileVo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author zkzong
 * @date 2017/10/20
 */
public interface FileRepository extends MongoRepository<FileVo, Long> {
    FileVo findById(Long id);
}
