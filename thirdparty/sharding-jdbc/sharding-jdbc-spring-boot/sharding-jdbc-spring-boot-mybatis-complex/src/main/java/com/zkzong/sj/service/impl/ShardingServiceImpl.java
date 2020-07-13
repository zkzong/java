package com.zkzong.sj.service.impl;

import com.zkzong.sj.entity.Other;
import com.zkzong.sj.entity.Sharding;
import com.zkzong.sj.repository.OtherRepository;
import com.zkzong.sj.repository.ShardingRepository;
import com.zkzong.sj.service.ShardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShardingServiceImpl implements ShardingService {

    @Autowired
    private OtherRepository otherRepository;

    @Autowired
    private ShardingRepository shardingRepository;

    @Override
    public void inertOther() {
        Other other = new Other();
        other.setUserName("zong");
        other.setAge(30);
        otherRepository.insert(other);
    }

    @Override
    public void inertSharding() {
        Sharding sharding1 = new Sharding();
        sharding1.setAppId("1001");
        sharding1.setNum(10);
        shardingRepository.insert(sharding1);

        Sharding sharding2 = new Sharding();
        sharding2.setAppId("1001");
        sharding2.setNum(11);
        shardingRepository.insert(sharding2);

        Sharding sharding3 = new Sharding();
        sharding3.setAppId("1002");
        sharding3.setNum(10);
        shardingRepository.insert(sharding3);

        Sharding sharding4 = new Sharding();
        sharding4.setAppId("1002");
        sharding4.setNum(11);
        shardingRepository.insert(sharding4);
    }
}
