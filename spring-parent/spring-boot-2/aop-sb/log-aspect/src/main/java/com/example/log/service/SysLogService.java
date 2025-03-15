package com.example.log.service;

import com.example.log.bo.SysLogBO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: zong
 * @Date: 2022/3/9
 */
@Slf4j
@Service
public class SysLogService {
    public boolean save(SysLogBO sysLogBO) {
        // 这里就不做具体实现了
        log.info(new Gson().toJson(sysLogBO));
        log.info(sysLogBO.getParams());
        return true;
    }
}
