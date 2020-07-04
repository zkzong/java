package com.zkzong.mysql.service;

import com.zkzong.mysql.entity.Member;

import java.util.List;

public interface MemberService {

    int insert(Member member);

    int save(Member member);

    List<Member> selectAll();

    String getToken(String appId);

}
