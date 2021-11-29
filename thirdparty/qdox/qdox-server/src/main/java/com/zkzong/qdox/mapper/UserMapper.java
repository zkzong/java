package com.zkzong.qdox.mapper;

import com.zkzong.api.QdoxClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: zong
 * @Date: 2021/11/26
 */
@Repository
public class UserMapper {

    @Autowired
    private QdoxClient qdoxClient;

    public void save() {
        qdoxClient.getName();
        System.out.println("save");
    }

}
