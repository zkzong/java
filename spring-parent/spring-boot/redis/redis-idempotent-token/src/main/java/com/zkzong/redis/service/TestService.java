package com.zkzong.redis.service;

import com.zkzong.redis.common.ServerResponse;
import com.zkzong.redis.pojo.Mail;

public interface TestService {

    ServerResponse testIdempotence();

    ServerResponse accessLimit();

    ServerResponse send(Mail mail);
}
