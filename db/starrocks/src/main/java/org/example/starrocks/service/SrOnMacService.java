package com.example.starrocks.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.starrocks.dto.SrOnMacDto;
import com.example.starrocks.entity.SrOnMac;

import java.util.List;

public interface SrOnMacService extends IService<SrOnMac> {

    List<SrOnMac> select(SrOnMacDto dto);

    int save();

    int insertOne(Long c0, String c1, String c2, String c3);

}
