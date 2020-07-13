package com.zkzong.sj.service.impl;

import com.zkzong.sj.entity.Other;
import com.zkzong.sj.repository.OtherRepository;
import com.zkzong.sj.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherServiceImpl implements OtherService {

    @Autowired
    private OtherRepository otherRepository;

    @Override
    public void addOther() {
        Other other = new Other();
        other.setUserName("zong");
        other.setAge(30);
        otherRepository.save(other);

    }

}
