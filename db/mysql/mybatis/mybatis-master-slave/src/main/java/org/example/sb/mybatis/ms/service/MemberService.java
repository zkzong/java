package org.example.sb.mybatis.ms.service;

import org.example.sb.mybatis.ms.entity.Member;

import java.util.List;

public interface MemberService {

    int insert(Member member);

    int save(Member member);

    List<Member> selectAll();

    String getToken(String appId);
}
