package com.zkzong.idempotent.service.impl;

import com.zkzong.idempotent.common.ServerResponse;
import com.zkzong.idempotent.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public ServerResponse testIdempotence() {
        return ServerResponse.success("testIdempotence: success");
    }

}
