package com.zkzong.idempotent.service;

import com.zkzong.idempotent.common.ServerResponse;

public interface TestService {

    ServerResponse testIdempotence();

}
