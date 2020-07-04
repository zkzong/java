package com.zkzong.sb.mybatis.ms.service;

import com.zkzong.sb.mybatis.ms.entity.Member;

import java.util.List;

public interface MemberService {

    int insert(Member member);

    int save(Member member);

    List<Member> selectAll();

    String getToken(String appId);
}
