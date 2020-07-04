package com.zkzong.springredis.case2.domain;

import java.io.Serializable;

/**
 * Created by Zong on 2017/3/4.
 */
public interface DomainObject extends Serializable {
    String getKey();
    String getObjectKey();
}
