package org.example.starrocks.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.starrocks.dto.SrOnMacDto;
import org.example.starrocks.entity.SrOnMac;
import org.example.starrocks.mapper.SrOnMacMapper;
import org.example.starrocks.service.SrOnMacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SrOnMacServiceImpl extends ServiceImpl<SrOnMacMapper, SrOnMac> implements SrOnMacService {

    @Autowired
    private SrOnMacMapper srOnMacMapper;

    @Override
    public List<SrOnMac> select(SrOnMacDto dto) {
        return srOnMacMapper.selectList(null);
    }

    @Override
    public int save() {
        SrOnMac srOnMac = new SrOnMac();
        srOnMac.setC0(9L);
        srOnMac.setC1(new Date(2022, 2, 5));
        srOnMac.setC2(new Date(2022, 2, 5));
        srOnMac.setC3("999");
        return srOnMacMapper.insert(srOnMac);
    }

    @Override
    public int insertOne(Long c0, String c1, String c2, String c3) {
        return srOnMacMapper.insertOne(c0, c1, c2, c3);
    }
}
