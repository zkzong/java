package com.zkzong.sj.repository;

import com.zkzong.sj.entity.Other;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OtherRepository {

    Long insert(Other other);

}
